package ee.valiit.goeatabit.domain.image;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import ee.valiit.goeatabit.util.ImageConverter;
import ee.valiit.goeatabit.validation.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImageService {


    @Resource
    private ImageRepository imageRepository;



    public Image saveImageData(SignUpRequest signUpRequest) {
        Image image = ImageConverter.imageStringToImageBytes(signUpRequest);
        image.setStatus(Status.ACTIVE.getLetter());
        Image savedImage = imageRepository.save(image);
        return savedImage;
    }

    public Image getImageBy(Integer FoodGroupId) {
        return imageRepository.getImageStringBy(FoodGroupId);

    }
}
