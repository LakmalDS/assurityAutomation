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
public class FeesDTO {
    @JsonProperty("Bundle")
    private Double bundle;
    @JsonProperty("EndDate")
    private Double endDate;
    @JsonProperty("Feature")
    private Double feature;
    @JsonProperty("Gallery")
    private Double gallery;
    @JsonProperty("Listing")
    private Double listing;
    @JsonProperty("Reserve")
    private Double reserve;
    @JsonProperty("Subtitle")
    private Double subtitle;
    @JsonProperty("TenDays")
    private Double tenDays;
    @JsonProperty("ListingFeeTiers")
    private List<ListingFeeTierDTO> listingFeeTiers = null;
    @JsonProperty("SecondCategory")
    private Double secondCategory;

    public FeesDTO() {

    }
}
