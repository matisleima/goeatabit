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

    public void saveImage(Image image) {
        imageRepository.save(image);
    }

    public Image getImageBy(Integer foodGroupId) {
        return imageRepository.getImageStringBy(foodGroupId);
    }
}
