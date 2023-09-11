package ee.valiit.goeatabit.domain.user;

import ee.valiit.goeatabit.business.login.dto.LoginResponse;
import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import ee.valiit.goeatabit.domain.contact.Contact;
import ee.valiit.goeatabit.domain.image.Image;
import ee.valiit.goeatabit.domain.location.Location;
import ee.valiit.goeatabit.domain.rating.Rating;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(constant = "0.0", target = "rating")
    User toUser(SignUpRequest signUpRequest);

    @Mapping(source = "imageData", target = "data")
    Image toImage(SignUpRequest signUpRequest);

    @Mapping(source = "firstName", target = "firstname")
    @Mapping(source = "lastName", target = "lastname")
    Contact toContact(SignUpRequest signUpRequest);

    @Mapping(source = "districtId", target = "district.id")
    @Mapping(source = "address", target = "address")
    Location toLocation(SignUpRequest signUpRequest);

}