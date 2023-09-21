package ee.valiit.goeatabit.business.meal.dto;

import ee.valiit.goeatabit.domain.event.Event;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

/**
 * DTO for {@link Event}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto implements Serializable {
    private Integer eventId;
    private Integer clientUserId;
    private Integer offerId;
    private Integer offerUserId;
    private BigDecimal offerUserRating;
    private Time time;
    private LocalDate date;
    private BigDecimal price;
    private Integer totalPortions;
    private String offerName;
    private String description;
    private String offerStatus;
    @NotNull
    private String eventStatus;

    private String firstName;
    private String lastName;

    private String address;
}