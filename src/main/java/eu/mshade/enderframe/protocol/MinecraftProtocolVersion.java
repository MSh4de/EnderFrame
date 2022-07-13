package eu.mshade.enderframe.protocol;

import java.util.HashMap;
import java.util.Map;

public enum MinecraftProtocolVersion {

    UNKNOWN(-1),
    V1_8(47),
    V1_9(107),
    V1_9_1(108),
    V1_9_2(109),
    V1_9_4(110),
    V1_10(210),
    V1_11(315),
    V1_11_1(316),
    V1_12(335),
    V1_12_1(338),
    V1_12_2(340),
    V1_13(393),
    V1_13_1(401),
    V1_13_2(404),
    V1_14(477),
    V1_14_1(480),
    V1_14_2(485),
    V1_14_3(490),
    V1_14_4(498),
    V1_15(573),
    V1_15_1(575),
    V1_15_2(578),
    V1_16(735),
    V1_16_1(736),
    V1_16_2(751),
    V1_16_3(753),
    V1_16_4(754);

    private int protocolVersion;

    private final static Map<Integer, MinecraftProtocolVersion> MAP = new HashMap<>();

    MinecraftProtocolVersion(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    static {
        for (MinecraftProtocolVersion minecraftProtocolVersion : MinecraftProtocolVersion.values()) {
            MAP.put(minecraftProtocolVersion.getProtocolVersion(), minecraftProtocolVersion);
        }
    }

    public static MinecraftProtocolVersion getProtocolVersion(int number){
        return MAP.getOrDefault(number, UNKNOWN);
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }
}
