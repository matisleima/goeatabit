package ee.valiit.goeatabit.business.meal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilteredOfferRequest {
    private Integer districtId;
    private String date;
    private Integer foodGroupId;
    private String description;
    private BigDecimal priceLimit;
}
