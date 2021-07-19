package eu.mshade.enderframe;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public class ServerListBuilder {

    private final JSONObject jsonobject = new JSONObject();

    private ServerListBuilder() { }

    public ServerListBuilder setVersion(String name, int protocol){
        JSONObject version = new JSONObject();
        version.put("name", name);
        version.put("protocol", protocol);
        jsonobject.put("version", version);
        return this;
    }

    public ServerListBuilder setPlayer(int maxplayers, int playersonline, ServerListPlayerBuilder... serverlistplayerbuilders){
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("max", maxplayers);
        jsonobject.put("online", playersonline);

        JSONArray array = new JSONArray();
        for (ServerListPlayerBuilder serverlistplayerbuilder : serverlistplayerbuilders) {
            JSONObject object = new JSONObject();
            object.put("name", serverlistplayerbuilder.getName());
            object.put("id", serverlistplayerbuilder.getId().toString());
            array.put(object);
        }
        jsonobject.put("sample", array);
        this.jsonobject.put("players", jsonobject);
        return this;
    }

    public ServerListBuilder setFavicon(File file){
        try {
            FileInputStream fileinputstream = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileinputstream.read(bytes);
            jsonobject.put("favicon", String.format("data:image/png;base64,%s", Base64.getEncoder().encodeToString(bytes)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }

    public ServerListBuilder setDescription(String description){
        jsonobject.put("description", new JSONObject().put("text", description));
        return this;
    }

    public String build(){
        return jsonobject.toString();
    }

    public static ServerListBuilder builder(){
        return new ServerListBuilder();
    }

}
