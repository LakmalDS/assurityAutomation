import org.testng.annotations.BeforeClass;
import responseObjects.PromotionsDTO;
import responseMethods.GetMethods;
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
    public void verifyGetCategoriesResponse() throws IOException, ParseException {
        String categoryName = "Carbon credits";
        String promoName = "Gallery";
        String promoDescription = "Good position in category";

        CategoriesDTO response = methods.getCategoriesResponse(6327, false);

        Assert.assertTrue(response.getName().equalsIgnoreCase(categoryName), "Category Name is incorrect");
        Assert.assertTrue(response.getCanRelist(), "CanRelist value is incorrect");
        Assert.assertTrue(getPromotionDescription(response.getPromotions(), promoName).equalsIgnoreCase(promoDescription),
                "Promotion does not have expected Description");
    }

    private String getPromotionDescription(List<PromotionsDTO> promotions, String promoName) {
        String description = "";
        if (promotions.isEmpty()) { return description; }
        for (PromotionsDTO promotion : promotions) {
            if (promotion.getName().equalsIgnoreCase(promoName)) {
                description = promotion.getDescription();
                break;
            }
        }
        return description;
    }
}
