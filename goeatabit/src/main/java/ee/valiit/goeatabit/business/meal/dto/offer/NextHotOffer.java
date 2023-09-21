package ee.valiit.goeatabit.business.meal.dto.offer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NextHotOffer implements Serializable {
    @NotNull
    private Integer offerId;
    @NotNull
    private Integer userId;
    @NotNull
    @Size(max = 255)
    private String offerName;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String imageString;
    private String address;
    private Time time;
    private LocalDate date;



}