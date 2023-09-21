package ee.valiit.goeatabit.business.meal.dto.offer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto implements Serializable {
    private Integer offerId;
    private Integer userId;
    private BigDecimal userRating;
    @NotNull
    private Time time;
    @NotNull
    private LocalDate date;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer totalPortions;
    @NotNull
    @Size(max = 255)
    private String offerName;
    @NotNull
    @Size(max = 255)
    private String description;
    private Integer foodGroupId;
    @NotNull
    private String offerStatus;

    @NotNull
    private String address;
    @NotNull
    private Integer districtId;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String imageString;

    private String userImageString;

}