package eu.mshade.enderframe.protocol;


import eu.mshade.mwork.MOptional;
import eu.mshade.mwork.MWork;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ProtocolRegistry {

    private Map<ProtocolStatus, Map<Integer, Class<? extends PacketIn>>> packetIn = new HashMap<>();
    private Map<ProtocolStatus, Map<Class<? extends PacketOut>,  Integer>> packetOut = new HashMap<>();

    public void registerIn(ProtocolStatus protocolStatus, int id, Class<? extends PacketIn> aClass){
        packetIn.computeIfAbsent(protocolStatus, p -> new HashMap<>()).putIfAbsent(id, aClass);
    }

    public void registerOut(ProtocolStatus protocolStatus, int id, Class<? extends PacketOut> aClass){
        packetOut.computeIfAbsent(protocolStatus, p -> new HashMap<>()).putIfAbsent(aClass, id);
    }


    public MOptional<PacketIn> getPacketByID(ProtocolStatus protocolStatus, int id){
        try {
            final Class<? extends PacketIn> aClass = packetIn.computeIfAbsent(protocolStatus, p -> new HashMap<>()).get(id);
            if(aClass != null) {
                Constructor<? extends PacketIn> constructor = aClass.getDeclaredConstructor();
                constructor.setAccessible(true);
                return MOptional.of(constructor.newInstance());
            }
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return MOptional.empty();
    }

    public MOptional<Integer> getPacketID(ProtocolStatus protocolStatus, PacketOut packet){
        return MOptional.ofNullable(packetOut.computeIfAbsent(protocolStatus, p -> new HashMap<>()).get(packet.getClass()));
    }
}
