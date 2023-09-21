package ee.valiit.goeatabit.business.meal.dto.offer;

import ee.valiit.goeatabit.domain.foodgroup.FoodGroup;
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
public class FilteredOffer implements Serializable {
    private Integer offerId;
    private Integer userId;
    private String offerName;
    private String description;
    private LocalDate date;
    private String time;
    private String address;
    private String firstName;
    private String lastName;
    private BigDecimal price;
    private Integer totalPortions;
    private BigDecimal userRating;
    private Integer foodGroupId;
}