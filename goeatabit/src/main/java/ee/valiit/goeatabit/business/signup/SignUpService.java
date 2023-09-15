package ee.valiit.goeatabit.business.signup;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import ee.valiit.goeatabit.domain.contact.Contact;
import ee.valiit.goeatabit.domain.contact.ContactMapper;
import ee.valiit.goeatabit.domain.contact.ContactService;
import ee.valiit.goeatabit.domain.image.Image;
import ee.valiit.goeatabit.domain.image.ImageService;
import ee.valiit.goeatabit.domain.location.Location;
import ee.valiit.goeatabit.domain.location.LocationMapper;
import ee.valiit.goeatabit.domain.location.LocationService;
import ee.valiit.goeatabit.domain.rating.Rating;
import ee.valiit.goeatabit.domain.rating.RatingService;
import ee.valiit.goeatabit.domain.role.Role;
import ee.valiit.goeatabit.domain.role.RoleService;
import ee.valiit.goeatabit.domain.user.User;
import ee.valiit.goeatabit.domain.user.UserMapper;
import ee.valiit.goeatabit.domain.user.UserService;
import ee.valiit.goeatabit.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Resource
    private RoleService roleService;
    @Resource
    private UserService userService;

    @Resource
    private RatingService ratingService;
    @Resource
    private ImageService imageService;
    @Resource
    private ContactService contactService;
    @Resource
    private LocationService locationService;
    @Resource
    private UserMapper userMapper;

    @Resource
    private ContactMapper contactMapper;
    @Resource
    private LocationMapper locationMapper;



    public void signUp(SignUpRequest signUpRequest) {
        userService.confirmUserAvailability(signUpRequest.getEmail());
        User user = createAndSaveUser(signUpRequest);
        createAndSaveRating(user);
        Image image = createImage(signUpRequest);
        createAndSaveContact(signUpRequest, user, image);


        Location location = locationMapper.toLocation(signUpRequest);
        location.setUser(user);
        locationService.saveLocation(location);
    }

    private Contact createAndSaveContact(SignUpRequest signUpRequest, User user, Image image) {
        Contact contact = createContact(signUpRequest, user, image);
        contactService.saveContact(contact);
        return contact;
    }

    private Contact createContact(SignUpRequest signUpRequest, User user, Image image) {
        Contact contact = contactMapper.toContact(signUpRequest);
        contact.setUser(user);
        contact.setImage(image);
        return contact;
    }

    private Image createImage(SignUpRequest signUpRequest) {
        Image image = null;
        if (hasImage(signUpRequest)) {
            image = createAndSaveImage(signUpRequest.getImageString());
        }
        return image;
    }

    private static boolean hasImage(SignUpRequest signUpRequest) {
        return !signUpRequest.getImageString().isEmpty();
    }

    private Image createAndSaveImage(String imageString) {
        Image image = ImageConverter.imageStringToImage(imageString);
        imageService.saveImage(image);
        return image;
    }


    private void createAndSaveRating(User user) {
        Rating rating = new Rating();
        rating.setCounter(0);
        rating.setSum(0);
        rating.setUser(user);
        ratingService.saveRating(rating);
    }

    private User createAndSaveUser(SignUpRequest signUpRequest) {
        User user = createUser(signUpRequest);
        userService.saveUser(user);
        return user;
    }

    private User createUser(SignUpRequest signUpRequest) {
        Role role = roleService.getRoleUser();
        User user = userMapper.toUser(signUpRequest);
        user.setRole(role);
        return user;
    }
}
