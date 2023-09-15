package ee.valiit.goeatabit.business.foodgroup;

import ee.valiit.goeatabit.domain.foodgroup.FoodGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link FoodGroup}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodGroupDto implements Serializable {
    @NotNull
    private Integer foodGroupId;
    @NotNull
    @Size(max = 255)
    private String foodGroupName;
}