package eu.mshade.enderframe.motd;

public class MotdVersion {

    private String name;
    private int protocol;

    private MotdVersion() { }

    public MotdVersion(String name, int protocol) {
        this.name = name;
        this.protocol = protocol;
    }

    public String getName() {
        return name;
    }

    public int getProtocol() {
        return protocol;
    }

    @Override
    public String toString() {
        return "MotdVersion{" +
                "name='" + name + '\'' +
                ", protocol=" + protocol +
                '}';
    }
}
