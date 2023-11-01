package ee.valiit.goeatabit.business.login;

import ee.valiit.goeatabit.business.login.dto.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = """
                         Kontrollib e-maili ja parooli kokkusobivust ja kasutaja olemasolu, 
                         edu korral tagastab kasutaja ID""")
    public LoginResponse login(@RequestParam String email, @RequestParam String password) {
        return loginService.login(email, password);
    }
}