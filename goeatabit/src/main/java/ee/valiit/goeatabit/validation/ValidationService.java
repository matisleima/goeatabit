package ee.valiit.goeatabit.validation;

import ee.valiit.goeatabit.domain.user.User;
import ee.valiit.goeatabit.infrastructure.exception.BusinessException;

import java.util.Optional;

import static ee.valiit.goeatabit.validation.Error.INCORRECT_CREDENTIALS;
import static ee.valiit.goeatabit.validation.Error.USER_EMAIL_UNAVAILABLE;

public class ValidationService {
    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void validateEmailIsAvailable(boolean userEmailExists) {
        if (userEmailExists) {
            throw new BusinessException(USER_EMAIL_UNAVAILABLE.getMessage(), USER_EMAIL_UNAVAILABLE.getErrorCode());
        }

    }
}
