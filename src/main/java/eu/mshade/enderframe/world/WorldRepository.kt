package eu.mshade.enderframe.world

object WorldRepository {

    private val worldByName = mutableMapOf<String, World>()

    fun getWorld(name: String): World? {
        return worldByName[name]
    }

    fun addWorld(world: World) {
        worldByName[world.name] = world
    }

    fun removeWorld(world: World) {
        worldByName.remove(world.name)
    }

    fun removeWorld(name: String) {
        worldByName.remove(name)
    }

    fun containsWorld(name: String): Boolean {
        return worldByName.containsKey(name)
    }

    fun getWorlds(): Collection<World> {
        return worldByName.values
    }

}