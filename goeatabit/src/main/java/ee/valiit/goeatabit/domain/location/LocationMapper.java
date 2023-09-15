package ee.valiit.goeatabit.domain.location;

import ee.valiit.goeatabit.business.district.dto.DistrictDto;
import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {
    @Mapping(source = "districtId", target = "district.id")
    @Mapping(source = "address", target = "address")
    Location toLocation(SignUpRequest signUpRequest);

    @Mapping(source = "district.id", target = "districtId")
    @Mapping(source = "district.name", target = "districtName")
    DistrictDto toDistrictDto(Location location);

}