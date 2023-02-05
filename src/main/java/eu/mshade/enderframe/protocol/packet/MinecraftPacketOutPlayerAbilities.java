package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;

public class MinecraftPacketOutPlayerAbilities implements MinecraftPacketOut {

    private boolean invulnerable;
    private boolean flying;
    private boolean allowFlying;
    private boolean instantBreak;
    private float flyingSpeed;
    private float walkSpeed;

    public MinecraftPacketOutPlayerAbilities(boolean invulnerable, boolean flying, boolean allowFlying, boolean instantBreak, float flyingSpeed, float walkSpeed) {
        this.invulnerable = invulnerable;
        this.flying = flying;
        this.allowFlying = allowFlying;
        this.instantBreak = instantBreak;
        this.flyingSpeed = flyingSpeed;
        this.walkSpeed = walkSpeed;
    }

    @Override
    public void serialize(MinecraftByteBuf minecraftByteBuf) {
        byte b = 0;

        if (this.invulnerable) b |= 1;
        if (this.flying)  b |= 2;
        if (this.allowFlying) b |= 4;
        if (this.instantBreak) b |= 8;

        minecraftByteBuf.writeByte(b);
        minecraftByteBuf.writeFloat(this.flyingSpeed);
        minecraftByteBuf.writeFloat(this.walkSpeed);
    }
}
