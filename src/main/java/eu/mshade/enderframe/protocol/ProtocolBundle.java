package eu.mshade.enderframe.protocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ProtocolBundle {

    private static ProtocolBundle protocolBundle;
    private final Logger logger = LoggerFactory.getLogger(ProtocolBundle.class);
    private final Map<MinecraftProtocolVersion, Protocol> protocolBufferByVersion = new HashMap<>();

    public ProtocolBundle() {
        protocolBundle = this;
    }

    public void register(Protocol protocol){
        logger.info(String.format("Register protocol %s", protocol.getMinecraftProtocolVersion()));
        protocolBufferByVersion.put(protocol.getMinecraftProtocolVersion(), protocol);
    }

    public Protocol getEnderFrameProtocolByVersion(MinecraftProtocolVersion version){
        return protocolBufferByVersion.get(version);
    }


    public static ProtocolBundle get(){
        return (protocolBundle == null ? new ProtocolBundle() : protocolBundle);
    }
}
