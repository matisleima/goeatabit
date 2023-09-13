package ee.valiit.goeatabit.util;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import ee.valiit.goeatabit.domain.image.Image;

import java.nio.charset.StandardCharsets;

public class ImageConverter {
    public static Image imageStringToImageBytes(SignUpRequest signUpRequest) {
        Image image = new Image();
        image.setData(signUpRequest.getImageString().getBytes(StandardCharsets.UTF_8));
        return image;

    }

    public static String imageBytesToImageString(Image image) {
        if (image == null) {
            return "";
        }
        return new String(image.getData(), StandardCharsets.UTF_8);
    }
}
