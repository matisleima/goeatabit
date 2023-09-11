package ee.valiit.goeatabit.domain.contact;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import ee.valiit.goeatabit.domain.image.Image;
import ee.valiit.goeatabit.domain.user.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;
    @Resource
    private ContactMapper contactMapper;

    public void saveContact(SignUpRequest signUpRequest, Image savedImage, User savedUser) {
        Contact contact = contactMapper.toContact(signUpRequest);
        contact.setUser(savedUser);
        contact.setImage(savedImage);
        contactRepository.save(contact);
    }
}
