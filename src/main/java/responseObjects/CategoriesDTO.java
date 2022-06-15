package responseObjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoriesDTO {
    @JsonProperty("CategoryId")
    private Integer categoryId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Path")
    private String path;
    @JsonProperty("CanListAuctions")
    private Boolean canListAuctions;
    @JsonProperty("CanListClassifieds")
    private Boolean canListClassifieds;
    @JsonProperty("CanRelist")
    private Boolean canRelist;
    @JsonProperty("LegalNotice")
    private String legalNotice;
    @JsonProperty("DefaultDuration")
    private Integer defaultDuration;
    @JsonProperty("AllowedDurations")
    private List<Integer> allowedDurations = null;
    @JsonProperty("Fees")
    private FeesDTO fees;
    @JsonProperty("FreePhotoCount")
    private Integer freePhotoCount;
    @JsonProperty("MaximumPhotoCount")
    private Integer maximumPhotoCount;
    @JsonProperty("IsFreeToRelist")
    private Boolean isFreeToRelist;
    @JsonProperty("Promotions")
    private List<PromotionsDTO> promotions = null;
    @JsonProperty("EmbeddedContentOptions")
    private List<Object> embeddedContentOptions = null;
    @JsonProperty("MaximumTitleLength")
    private Integer maximumTitleLength;
    @JsonProperty("AreaOfBusiness")
    private Integer areaOfBusiness;
    @JsonProperty("DefaultRelistDuration")
    private Integer defaultRelistDuration;
    @JsonProperty("CanUseCounterOffers")
    private Boolean canUseCounterOffers;

    public CategoriesDTO() {

    }
}
