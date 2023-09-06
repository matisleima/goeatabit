package ee.valiit.goeatabit.business;

public class LoginService {


    private UserService userService;


    public void login(String email, String password) {
        userService.findActiveUserBy(email, password);
    }
}
