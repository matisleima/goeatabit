package ee.valiit.goeatabit.business.meal.dto.offer;

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
public class BookingConfirmationInfo implements Serializable {
    private LocalDate date;
    private String time;
    private String address;
    private String firstName;
    private String lastName;
    private String offerName;
    private String description;
    private BigDecimal price;
    private BigDecimal userRating;
}