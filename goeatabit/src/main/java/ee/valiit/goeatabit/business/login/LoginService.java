package ee.valiit.goeatabit.business.login;

import ee.valiit.goeatabit.domain.user.User;
import ee.valiit.goeatabit.domain.user.UserMapper;
import ee.valiit.goeatabit.business.UserService;
import ee.valiit.goeatabit.business.login.dto.LoginResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;



    public LoginResponse login(String email, String password) {
        User user = userService.findActiveUserBy(email, password);
        return userMapper.toLoginResponse(user);
    }
}
