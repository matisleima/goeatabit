package ee.valiit.goeatabit.domain.user;

import ee.valiit.goeatabit.business.login.dto.LoginResponse;
import ee.valiit.goeatabit.domain.user.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    LoginResponse toLoginResponse(User user);


}