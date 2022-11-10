package eu.mshade.enderframe.protocol;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MinecraftPacketRegistry {

    private Map<MinecraftProtocolStatus, Map<Integer, Class<? extends MinecraftPacketIn>>> packetIn = new HashMap<>();
    private Map<MinecraftProtocolStatus, Map<Class<? extends MinecraftPacketOut>,  Integer>> packetOut = new HashMap<>();

    public void registerIn(MinecraftProtocolStatus minecraftProtocolStatus, int id, Class<? extends MinecraftPacketIn> aClass){
        packetIn.computeIfAbsent(minecraftProtocolStatus, p -> new HashMap<>()).putIfAbsent(id, aClass);
    }

    public void registerOut(MinecraftProtocolStatus minecraftProtocolStatus, int id, Class<? extends MinecraftPacketOut> aClass){
        packetOut.computeIfAbsent(minecraftProtocolStatus, p -> new HashMap<>()).putIfAbsent(aClass, id);
    }


    public MinecraftPacketIn getPacketByID(MinecraftProtocolStatus minecraftProtocolStatus, int id){
        try {
            final Class<? extends MinecraftPacketIn> aClass = packetIn.computeIfAbsent(minecraftProtocolStatus, p -> new HashMap<>()).get(id);
            if(aClass != null) {
                Constructor<? extends MinecraftPacketIn> constructor = aClass.getDeclaredConstructor();
                constructor.setAccessible(true);
                return constructor.newInstance();
            }
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getPacketID(MinecraftProtocolStatus minecraftProtocolStatus, MinecraftPacketOut packet){
        return packetOut.computeIfAbsent(minecraftProtocolStatus, p -> new HashMap<>()).getOrDefault(packet.getClass(), -1);
    }
}
