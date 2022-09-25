package helper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Helper {
    public JSONObject getJsonData() {
        JSONParser parseJson = new JSONParser();
        FileReader newFile;
        Object jsonObject = null;
        try {
            newFile = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\TeamRcb.json");
            jsonObject = parseJson.parse(newFile);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ParseException e) {

        }
        return (JSONObject) jsonObject;
    }

    public List<String> getAttributeOfPlayers(JSONArray playerJsonArray, String role) {
        return Collections.emptyList();
    }
}
