package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.protocol.ProtocolVersion;

import java.net.InetSocketAddress;

public interface Player extends Entity {

    String getName();

    InetSocketAddress getInetSocketAddress();

    ProtocolVersion getProtocolVersion();

    void sendKeepAlive(int threshold);

    int getPing();

}
