package ee.valiit.goeatabit.business.image;

import ee.valiit.goeatabit.domain.contact.Contact;
import ee.valiit.goeatabit.domain.contact.ContactService;
import ee.valiit.goeatabit.domain.image.Image;
import ee.valiit.goeatabit.domain.image.ImageService;
import ee.valiit.goeatabit.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImagesService {

    @Resource
    private ImageService imageService;

    @Resource
    private ContactService contactService;

    public String getImage(Integer userId) {
        Contact contact = contactService.getContactBy(userId);
        Image userImage = imageService.getUserImage(contact.getImage().getId());
        return ImageConverter.imageBytesToImageString(userImage);
    }
}
