package ee.valiit.goeatabit;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
public class LoginResponse implements Serializable {
    Integer id;
}