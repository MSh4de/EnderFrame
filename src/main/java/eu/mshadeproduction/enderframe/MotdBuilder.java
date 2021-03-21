package eu.mshadeproduction.enderframe;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public class MotdBuilder {

    private final JSONObject jsonObject = new JSONObject();

    private MotdBuilder() { }

    public MotdBuilder setVersion(String name, int protocol){
        JSONObject version = new JSONObject();
        version.put("name", name);
        version.put("protocol", protocol);
        jsonObject.put("version", version);
        return this;
    }

    public MotdBuilder setPlayer(int maxPlayers, int playersOnline){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("max", maxPlayers);
        jsonObject.put("online", playersOnline);
        this.jsonObject.put("players", jsonObject);
        return this;
    }

    public MotdBuilder setFavIcon(File file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStream.read(bytes);
            jsonObject.put("favicon", String.format("data:image/png;base64,%s", Base64.getEncoder().encodeToString(bytes)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }

    public MotdBuilder setDescription(String description){
        jsonObject.put("description", new JSONObject(ComponentSerializer.toString(new TextComponent(description))));
        return this;
    }

    public String build(){
        return jsonObject.toString();
    }

    public static MotdBuilder builder(){
        return new MotdBuilder();
    }

}
