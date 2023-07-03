package eu.mshade.enderframe.entity

import eu.mshade.enderframe.Agent
import eu.mshade.enderframe.GameMode
import eu.mshade.enderframe.entity.metadata.EntityMetadataKey
import eu.mshade.enderframe.inventory.*
import eu.mshade.enderframe.item.ItemStack
import eu.mshade.enderframe.mojang.GameProfile
import eu.mshade.enderframe.protocol.MinecraftProtocolVersion
import eu.mshade.enderframe.protocol.MinecraftSession
import eu.mshade.enderframe.scoreboard.Scoreboard
import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.border.WorldBorder
import eu.mshade.enderframe.world.chunk.Chunk
import java.net.InetSocketAddress
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue

abstract class Player : Entity, Agent, Equipable {

    var inetSocketAddress: InetSocketAddress? = null
    var minecraftProtocolVersion: MinecraftProtocolVersion? = null
    var ping = 0
    var displayName: String? = null
    var gameMode = GameMode.UNKNOWN
    var gameProfile: GameProfile? = null
        protected set
    var isInvulnerable = false
    var isFlying = false
    var isAllowFlying = false
    var isInstantBreak = false
    var flyingSpeed = 0f
    var walkSpeed = 0f
    var inventory: PlayerInventory? = null
        protected set
    var openedInventory: Inventory? = null
    val lookAtChunks: Queue<Chunk> = ConcurrentLinkedQueue()
    var inventoryBufferStore = InventoryClickStore()
        protected set
    private var lookAtScoreboard: Queue<Scoreboard> = ConcurrentLinkedQueue()
    private var lookAtEntity: Queue<Entity> = ConcurrentLinkedQueue()
    private var worldBorder: WorldBorder? = null

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID, entityKey: EntityKey) : super(location, velocity, entityId, uuid, entityKey)
    constructor(location: Location, entityId: Int, entityKey: EntityKey) : super(location, entityId, entityKey)
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(location, velocity, entityId, uuid, EntityType.PLAYER)
    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.PLAYER)

    val name: String?
        get() = gameProfile?.name


    fun hasLookAtChunk(chunk: Chunk): Boolean {
        return lookAtChunks.contains(chunk)
    }

    fun hasLookAtChunk(chunkX: Int, chunkZ: Int): Boolean {
        return lookAtChunks.stream().anyMatch { chunk: Chunk -> chunk.x == chunkX && chunk.z == chunkZ }
    }

    fun openInventory(inventory: NamedInventory) {
        openedInventory = inventory
        minecraftSession.sendOpenInventory(inventory)
        minecraftSession.sendItemStacks(inventory)
        inventory.addWatcher(this)
    }

    fun getLookAtScoreboard(): MutableCollection<Scoreboard> {
        return lookAtScoreboard
    }

    fun getWorldBorder(): WorldBorder? {
        return worldBorder
    }

    fun setWorldBorder(worldBorder: WorldBorder) {
        this.worldBorder = worldBorder
        if (!worldBorder.isWatching(this)) {
            worldBorder.addWatcher(this)
        }
    }

    abstract fun joinWorld(world: World?)

    abstract val minecraftSession: MinecraftSession

    fun sendChunk(chunk: Chunk){
        if (chunk.isWatching(this)) return
        minecraftSession.sendChunk(chunk)
        chunk.addWatcher(this)
        this.lookAtChunks.add(chunk)
    }

    fun isSneaking(): Boolean {
        var metadataKeyValue = metadata.getMetadataKeyValue(EntityMetadataKey.CROUCHED)
        return metadataKeyValue != null && metadataKeyValue.metadataValue as Boolean
    }

    fun getLookAtEntity(): Collection<Entity> {
        return lookAtEntity
    }

    fun addLookAtEntity(entity: Entity) {
        if (lookAtEntity.contains(entity)) return
        lookAtEntity.add(entity)
    }

    fun removeLookAtEntity(entity: Entity) {
        lookAtEntity.remove(entity)
    }

    override fun getEquipment(slot: EquipmentSlot): ItemStack? {
        return inventory?.getItemStack(slot)
    }

    override fun setEquipment(slot: EquipmentSlot, itemStack: ItemStack?) {
        inventory?.setItemStack(slot, itemStack)
    }

    override fun getEquipments(): Map<EquipmentSlot, ItemStack> {
        val equipments = mutableMapOf<EquipmentSlot, ItemStack>()

        for (slot in EquipmentSlot.values()) {
            getEquipment(slot)?.let { equipments[slot] = it }
        }

        return equipments
    }
}
