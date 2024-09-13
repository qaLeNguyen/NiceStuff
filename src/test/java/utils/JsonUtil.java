package utils;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtil {

    public static JSONArray parseJsonFile(String filePath) {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = jsonParser.parse(reader);
            jsonArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }
}