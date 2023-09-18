package ee.valiit.goeatabit.business.meal;

import ee.valiit.goeatabit.business.meal.dto.EventDto;
import ee.valiit.goeatabit.business.offer.dto.FilteredOffer;
import ee.valiit.goeatabit.business.offer.dto.OfferDto;
import ee.valiit.goeatabit.domain.event.Event;
import ee.valiit.goeatabit.domain.event.EventMapper;
import ee.valiit.goeatabit.domain.event.EventService;
import ee.valiit.goeatabit.domain.foodgroup.FoodGroup;
import ee.valiit.goeatabit.business.foodgroup.FoodGroupsService;
import ee.valiit.goeatabit.domain.offer.Offer;
import ee.valiit.goeatabit.business.meal.dto.FilteredOfferRequest;
import ee.valiit.goeatabit.domain.contact.Contact;
import ee.valiit.goeatabit.domain.contact.ContactService;
import ee.valiit.goeatabit.domain.image.Image;
import ee.valiit.goeatabit.domain.image.ImageService;
import ee.valiit.goeatabit.domain.location.Location;
import ee.valiit.goeatabit.domain.location.LocationService;
import ee.valiit.goeatabit.domain.offer.OfferMapper;
import ee.valiit.goeatabit.domain.offer.OfferService;
import ee.valiit.goeatabit.domain.user.User;
import ee.valiit.goeatabit.domain.user.UserService;
import ee.valiit.goeatabit.util.ImageConverter;
import ee.valiit.goeatabit.validation.Status;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Resource
    private OfferService offerService;
    @Resource
    private UserService userService;
    @Resource
    private LocationService locationService;
    @Resource
    private ContactService contactService;
    @Resource
    private ImageService imageService;
    @Resource
    private FoodGroupsService foodGroupsService;
    @Resource
    private EventService eventService;
    @Resource
    private OfferMapper offerMapper;
    @Resource
    private EventMapper eventMapper;


    public List<OfferDto> getOffers() {
        List<Offer> activeOffers = offerService.getActiveOffers();
        List<OfferDto> offerDtos = offerMapper.toOfferDtos(activeOffers);
        addLocationInfoToOfferDtos(offerDtos);
        addContactInfoToOfferDtos(offerDtos);
        addPhotoStringToDtos(offerDtos);
        return offerDtos;
    }

    private void addLocationInfoToOfferDtos(List<OfferDto> offerDtos) {
        for (OfferDto offerDto : offerDtos) {
            Location location = locationService.getLocationBy(offerDto.getUserId());
            offerDto.setAddress(location.getAddress());
            offerDto.setDistrictId(location.getDistrict().getId());
        }
    }

    private void addContactInfoToOfferDtos(List<OfferDto> offerDtos) {
        for (OfferDto offerDto : offerDtos) {
            Contact contact = contactService.getContactBy(offerDto.getUserId());
            offerDto.setFirstName(contact.getFirstname());
            offerDto.setLastName(contact.getLastname());

            offerDto.setUserImageString(String.valueOf(contact.getImage()));
        }
    }

    public List<FilteredOffer> getFilteredOffers(FilteredOfferRequest request) {

        List<Offer> offers = offerService.getFilteredOffers(request);
        List<FilteredOffer> filteredOffers = offerMapper.toFilteredOffers(offers);
        addContactInfoToFilteredOffers(filteredOffers);
        return filteredOffers;
    }

    private void addContactInfoToFilteredOffers(List<FilteredOffer> filteredOffers) {
        for (FilteredOffer filteredOffer : filteredOffers) {
            Contact contact = contactService.getContactBy(filteredOffer.getUserId());
            filteredOffer.setFirstName(contact.getFirstname());
            filteredOffer.setLastName(contact.getLastname());
        }
    }

    private void addPhotoStringToDtos(List<OfferDto> offerDtos) {
        for (OfferDto offerDto : offerDtos) {
            Image image = imageService.getImageBy(offerDto.getFoodGroupId());
            String imageString = ImageConverter.imageBytesToImageString(image);
            offerDto.setImageString(imageString);
        }
    }

    @Transactional
    public void addOffer(OfferDto request) {
        createAndSaveOffer(request);
    }

    private void createAndSaveOffer(OfferDto request) {
        Offer offer = createOffer(request);
        offerService.saveOffer(offer);
    }

    private Offer createOffer(OfferDto request) {
        Integer userId = request.getUserId();
        User user = userService.getUserBy(userId);
        Location location = locationService.getLocationBy(userId);
        FoodGroup foodGroup = foodGroupsService.getFoodGroupBy(request.getFoodGroupId());
        Offer offer = offerMapper.toOffer(request);
        offer.setUser(user);
        offer.setLocation(location);
        offer.setFoodGroup(foodGroup);
        return offer;
    }

    public OfferDto getOffer(Integer offerId, Integer userId) {
        Offer selectedOffer = offerService.getOffer(offerId);
        OfferDto selectedOfferDto = offerMapper.toOfferDto(selectedOffer);
        addContactAndLocationDataToSelectedOfferDto(userId, selectedOfferDto);
        return selectedOfferDto;
    }

    private void addContactAndLocationDataToSelectedOfferDto(Integer userId, OfferDto selectedOfferDto) {
        Contact contact = contactService.getContactBy(userId);
        selectedOfferDto.setFirstName(contact.getFirstname());
        selectedOfferDto.setLastName(contact.getLastname());
        Location location = locationService.getLocationBy(userId);
        selectedOfferDto.setAddress(location.getAddress());
    }

    public void addEvent(Integer offerId, Integer userId) {
        Offer offer = offerService.getOffer(offerId);
        User user = userService.getUserBy(userId);

        Event event = new Event();
        event.setOffer(offer);
        event.setUser(user);
        event.setStatus(Status.ACTIVE.getLetter());

        eventService.saveEvent(event);
    }

    public List<EventDto> getMyEvents(Integer userId) {
        List<Event> myEvents = eventService.getMyEvents(userId);
        List<EventDto> myEventDtos = eventMapper.toEventDtos(myEvents);
        addContactAndLocationDataToMyEventsDtos(myEventDtos);
        return myEventDtos;
    }

    private void addContactAndLocationDataToMyEventsDtos(List<EventDto> myEventDtos) {
        for (EventDto eventDto : myEventDtos) {
            Contact contact = contactService.getContactBy(eventDto.getOfferUserId());
            Location location = locationService.getLocationBy(eventDto.getOfferUserId());
            eventDto.setFirstName(contact.getFirstname());
            eventDto.setLastName(contact.getLastname());
            eventDto.setAddress(location.getAddress());
        }
    }
}
