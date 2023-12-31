package ee.valiit.goeatabit.domain.contact;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {

    @Mapping(source = "lastName", target = "lastname")
    @Mapping(source = "firstName", target = "firstname")
    Contact toContact(SignUpRequest signUpRequest);
}