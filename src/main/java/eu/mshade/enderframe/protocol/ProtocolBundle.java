package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.EnderFrameProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ProtocolBundle {

    private static ProtocolBundle protocolBundle;
    private final Logger logger = LoggerFactory.getLogger(ProtocolBundle.class);
    private final Map<MinecraftProtocolVersion, EnderFrameProtocol> protocolBufferByVersion = new HashMap<>();

    public ProtocolBundle() {
        protocolBundle = this;
    }

    public void register(EnderFrameProtocol enderFrameProtocol){
        logger.info(String.format("Register protocol %s", enderFrameProtocol.getMinecraftProtocolVersion()));
        protocolBufferByVersion.put(enderFrameProtocol.getMinecraftProtocolVersion(), enderFrameProtocol);
    }

    public EnderFrameProtocol getEnderFrameProtocolByVersion(MinecraftProtocolVersion version){
        return protocolBufferByVersion.get(version);
    }


    public static ProtocolBundle get(){
        return (protocolBundle == null ? new ProtocolBundle() : protocolBundle);
    }
}
