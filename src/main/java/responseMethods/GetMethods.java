package responseMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import fileReaders.ApiConfigsReader;
import org.json.simple.parser.ParseException;
import responseObjects.CategoriesDTO;

import java.io.IOException;

public class GetMethods {

    /**
     * This method is reusable by providing the required category Id and the isCatalogue boolean value.
     * RequestURL is generated by acquiring url content through ApiConfigsReader from specified json file.
     * RequestURL is then updated by replacing placeholder texts in the URL with user provided information.
     * The response is mapped to the object classes to create a Java object and then sent to the test layer.
     * @param categoryId
     * @param isCatalogue
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public CategoriesDTO getCategoriesResponse(int categoryId, boolean isCatalogue) throws IOException, ParseException {

        Response response;
        ApiConfigsReader apiConfigsReader = new ApiConfigsReader();
        String requestUrl = apiConfigsReader.getBaseUrl() + apiConfigsReader.getCategoriesUrl();
        requestUrl = requestUrl.replace("@categoryId", String.valueOf(categoryId)).replace("@isCatalogue", String.valueOf(isCatalogue));

        response = RestAssured.get(requestUrl);
        if (response.statusCode() != 200) {
            System.out.println("Status code of request is: " + response.statusCode());
        }

        CategoriesDTO categoriesResponseDTO = new ObjectMapper().readValue(response.asInputStream(), CategoriesDTO.class);

        return categoriesResponseDTO;
    }
}
