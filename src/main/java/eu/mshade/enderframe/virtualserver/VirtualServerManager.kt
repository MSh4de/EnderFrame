package eu.mshade.enderframe.virtualserver

class VirtualServerManager {

    private val virtualServers = mutableMapOf<String, VirtualServer>()

    fun getVirtualServer(name: String): VirtualServer? {
        return virtualServers[name]
    }

    fun getVirtualServers(): List<VirtualServer> {
        return virtualServers.values.toList()
    }


}