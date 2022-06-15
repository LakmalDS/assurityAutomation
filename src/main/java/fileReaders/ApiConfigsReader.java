package fileReaders;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ApiConfigsReader {
    private JSONParser jsonParser;
    private FileReader fileReader;
    private JSONObject jsonObject;
    private Object object;
    private final String jsonFilePath = "src//main//resources//apiConfigs.json";


    public ApiConfigsReader() throws IOException, ParseException {
        fileReader = new FileReader(jsonFilePath);
        jsonParser = new JSONParser();
        object = jsonParser.parse(fileReader);
        jsonObject = (JSONObject) object;
        fileReader.close();
    }

    public String getBaseUrl() {
        return (String) jsonObject.get("baseUrl");
    }

    public String getCategoriesUrl() {
        return (String) jsonObject.get("categoriesUrl");
    }
}
