package ee.valiit.goeatabit.domain.offer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link Offer}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferFilterDto implements Serializable {
    private Integer userId;
    @NotNull
    @Size(max = 255)
    private String time;
    @NotNull
    private LocalDate date;
    @NotNull
    private BigDecimal price;
    @NotNull
    @Size(max = 255)
    private String description;
    private Integer foodGroupId;
    @NotNull
    private String status;
}