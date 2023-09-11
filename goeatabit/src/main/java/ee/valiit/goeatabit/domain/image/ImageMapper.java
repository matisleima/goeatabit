package ee.valiit.goeatabit.domain.image;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {
    Image toEntity(SignUpRequest signUpRequest);

    SignUpRequest toDto(Image image);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Image partialUpdate(SignUpRequest signUpRequest, @MappingTarget Image image);
}