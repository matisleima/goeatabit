package ee.valiit.goeatabit.util;

import ee.valiit.goeatabit.domain.image.Image;
import ee.valiit.goeatabit.validation.Status;

import java.nio.charset.StandardCharsets;

public class ImageConverter {
    public static Image imageStringToImage(String imageString) {
        Image image = new Image();
        image.setData(imageString.getBytes(StandardCharsets.UTF_8));
        image.setStatus(Status.ACTIVE.getLetter());
        return image;

    }

    public static String imageBytesToImageString(Image image) {
        if (image == null) {
            return "";
        }
        return new String(image.getData(), StandardCharsets.UTF_8);
    }
}
