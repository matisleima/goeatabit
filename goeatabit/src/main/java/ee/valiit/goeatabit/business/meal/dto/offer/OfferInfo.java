package ee.valiit.goeatabit.business.meal.dto.offer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferInfo implements Serializable {
    @NotNull
    private LocalDate date;
    @NotNull
    private Integer time;
    @NotNull
    private Integer foodGroupId;
    @NotNull
    @Size(max = 255)
    private String offerName;

    @NotNull
    @Size(max = 255)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer totalPortions;

}