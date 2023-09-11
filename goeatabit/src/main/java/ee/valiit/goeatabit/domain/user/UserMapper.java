package ee.valiit.goeatabit.domain.user;

import ee.valiit.goeatabit.business.login.dto.LoginResponse;
import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(constant = "0.0", target = "rating")
    User toUser(SignUpRequest signUpRequest);
}