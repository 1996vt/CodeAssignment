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

    /**
     * Method to read Json data
     * @return Json object
     */
    public JSONObject getJsonData() {
        JSONParser parseJson = new JSONParser();
        FileReader newFile;
        Object jsonObject = null;
        try {
            newFile = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\TeamRcb.json");
            jsonObject = parseJson.parse(newFile);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage() + "File doest not exist");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage() + "Unable to read data from the source");
        } catch (ParseException pe) {
            System.out.println(pe.getMessage() + "unable to parse Json");
        }
        return (JSONObject) jsonObject;
    }
}
