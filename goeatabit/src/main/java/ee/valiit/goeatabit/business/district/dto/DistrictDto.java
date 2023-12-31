package ee.valiit.goeatabit.business.district.dto;

import ee.valiit.goeatabit.domain.district.District;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link District}
 */
@Value
public class DistrictDto implements Serializable {
    Integer districtId;
    @NotNull
    @Size(max = 255)
    String districtName;
}