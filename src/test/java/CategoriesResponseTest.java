import org.testng.annotations.BeforeClass;
import responseObjects.PromotionsDTO;
import responseMethods.GetMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import responseObjects.CategoriesDTO;

import java.io.IOException;
import java.util.List;

public class CategoriesResponseTest {

    GetMethods methods;

    @BeforeClass
    public void beforeClass() {
        methods = new GetMethods();
    }

    @Test
    public void getResponse() {
        String baseUri = "https://api.tmsandbox.co.nz/v1/Categories/@categoryId/Details.json";
        String paramCatalogue = "?catalogue=@isCatalogue";
        String categoryId = "6327";
        String isCatalogue = "false";

        String uri = baseUri.replace("@categoryId", categoryId) + paramCatalogue.replace("@isCatalogue", isCatalogue);
        Response response = RestAssured.get(uri);

        Assert.assertEquals(response.statusCode(), 200, "Invalid status code received");
        Assert.assertEquals(response.getBody().path("CategoryId"), Integer.valueOf(categoryId), "Incorrect category id retrieved");
        Assert.assertEquals(response.getBody().path("Name"), "Carbon credits");
        Assert.assertEquals(response.getBody().path("CanRelist"), true);

        List<Object> promotions = response.getBody().path("Promotions");
        for (int i=0; i < promotions.size(); i++) {
            String namePath = "Promotions[@i].Name";
            String descriptionPath = "Promotions[@i].Description";
            if (response.getBody().path(namePath.replace("@i", String.valueOf(i))).equals("Gallery")) {
                Assert.assertEquals(response.getBody().path(descriptionPath.replace("@i", String.valueOf(i))), "Good position in category");
            }
        }
    }

    @Test
    public void verifyGetCategoriesResponse() throws IOException, ParseException {
        String categoryName = "Carbon credits";
        String promoName = "Gallery";
        String promoDescription = "Good position in category";

        CategoriesDTO response = methods.getCategoriesResponse(6327, false);

        Assert.assertTrue(response.getName().equalsIgnoreCase(categoryName), "Category Name is incorrect");
        Assert.assertTrue(response.getCanRelist(), "CanRelist value is incorrect");
        Assert.assertTrue(isPromotionAvailable(response.getPromotions(), promoName), "Promotion is not available");
        Assert.assertTrue(getPromotionDescription(response.getPromotions(), promoName).equalsIgnoreCase(promoDescription),
                "Promotion does not have expected Description");
    }

    private boolean isPromotionAvailable(List<PromotionsDTO> promotions, String promoName) {
        boolean isPromotionAvailable = false;
        if (promotions.isEmpty()) { return false; }
        for (PromotionsDTO promotion : promotions) {
            if (promotion.getName().equalsIgnoreCase(promoName)) {
                isPromotionAvailable = true;
            }
        }
        return isPromotionAvailable;
    }

    private String getPromotionDescription(List<PromotionsDTO> promotions, String promoName) {
        String description = "";
        if (promotions.isEmpty()) { return description; }
        for (PromotionsDTO promotion : promotions) {
            if (promotion.getName().equalsIgnoreCase(promoName)) {
                description = promotion.getDescription();
            }
        }
        return description;
    }
}
