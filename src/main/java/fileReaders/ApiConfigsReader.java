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

    /**
     * Value in the provided json file is read. The value is then parsed
     * and the content outputted as a json object.
     * @throws IOException
     * @throws ParseException
     */
    public ApiConfigsReader() throws IOException, ParseException {
        fileReader = new FileReader(jsonFilePath);
        jsonParser = new JSONParser();
        object = jsonParser.parse(fileReader);
        jsonObject = (JSONObject) object;
        fileReader.close();
    }

    /**
     * Get method allows you to access only the required url content
     * @return
     */
    public String getBaseUrl() {
        return (String) jsonObject.get("baseUrl");
    }

    public String getCategoriesUrl() {
        return (String) jsonObject.get("categoriesUrl");
    }
}
