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
public class ListingFeeTierDTO {
    @JsonProperty("MinimumTierPrice")
    private Integer minimumTierPrice;
    @JsonProperty("FixedFee")
    private Double fixedFee;

    public ListingFeeTierDTO() {

    }
}
