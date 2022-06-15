package responseObjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromotionsDTO {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Price")
    private Double price;
    @JsonProperty("MinimumPhotoCount")
    private Integer minimumPhotoCount;
    @JsonProperty("OriginalPrice")
    private Double originalPrice;
    @JsonProperty("Recommended")
    private Boolean recommended;

    public PromotionsDTO() {

    }
}
