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

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    public Contact getContactBy(Integer userId) {
        return contactRepository.getContactBy(userId);
    }
}
