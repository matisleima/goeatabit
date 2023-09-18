package ee.valiit.goeatabit.domain.image;

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

    public Image getUserImage(Integer imageId) {
        return imageRepository.getImageStringBy(imageId);
    }
}
