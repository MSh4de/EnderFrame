package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.PacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class PacketOutPlayerAbilities implements PacketOut {

    private boolean invulnerable;
    private boolean flying;
    private boolean allowFlying;
    private boolean instantBreak;
    private float flyingSpeed;
    private float walkSpeed;

    public PacketOutPlayerAbilities(boolean invulnerable, boolean flying, boolean allowFlying, boolean instantBreak, float flyingSpeed, float walkSpeed) {
        this.invulnerable = invulnerable;
        this.flying = flying;
        this.allowFlying = allowFlying;
        this.instantBreak = instantBreak;
        this.flyingSpeed = flyingSpeed;
        this.walkSpeed = walkSpeed;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        byte b = 0;

        if (this.invulnerable) b |= 1;
        if (this.flying)  b |= 2;
        if (this.allowFlying) b |= 4;
        if (this.instantBreak) b |= 8;

        protocolBuffer.writeByte(b);
        protocolBuffer.writeFloat(this.flyingSpeed);
        protocolBuffer.writeFloat(this.walkSpeed);
    }
}
