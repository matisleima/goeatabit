package ee.valiit.goeatabit.business.meal;

import ee.valiit.goeatabit.Offer;
import ee.valiit.goeatabit.domain.contact.Contact;
import ee.valiit.goeatabit.domain.contact.ContactService;
import ee.valiit.goeatabit.domain.image.Image;
import ee.valiit.goeatabit.domain.image.ImageService;
import ee.valiit.goeatabit.domain.location.Location;
import ee.valiit.goeatabit.domain.location.LocationService;
import ee.valiit.goeatabit.domain.offer.dto.OfferDto;
import ee.valiit.goeatabit.domain.offer.OfferMapper;
import ee.valiit.goeatabit.domain.offer.OfferService;
import ee.valiit.goeatabit.util.ImageConverter;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class MealService {
    @Resource
    private OfferService offerService;
    @Resource
    private LocationService locationService;

    @Resource
    private ContactService contactService;
    @Resource
    private OfferMapper offerMapper;

    @Resource
    private ImageService imageService;


    public List<OfferDto> getOffers() {
        List<ee.valiit.goeatabit.Offer> activeOffers = offerService.getActiveOffers();
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
        }
    }

    public List<OfferDto> getFilteredOffers(Integer districtId,
                                            LocalDate date,
                                            Integer foodGroupId,
                                            String description,
                                            BigDecimal priceLimit,
                                            Integer userId) {

        List<Offer> filteredOffers = offerService.getFilteredOffers(date, foodGroupId, description, priceLimit);
        List<OfferDto> filteredOfferDtos = offerMapper.toOfferDtos(filteredOffers);
        setLocationAndContactInfoToFilteredOfferDtos(districtId, userId, filteredOfferDtos);
        return filteredOfferDtos;
    }

    private void setLocationAndContactInfoToFilteredOfferDtos(Integer districtId, Integer userId, List<OfferDto> filteredOfferDtos) {
        for (OfferDto offerDto : filteredOfferDtos) {
            Location location = locationService.getLocationByDistrict(districtId);
            offerDto.setAddress(location.getAddress());
            offerDto.setDistrictId(districtId);

            Contact contact = contactService.getContactBy(userId);
            offerDto.setFirstName(contact.getFirstname());
            offerDto.setLastName(contact.getLastname());
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
        ee.valiit.goeatabit.Offer offer = createOffer(request);
        offerService.saveOffer(offer);
    }

    private ee.valiit.goeatabit.Offer createOffer(OfferDto request) {
        return offerMapper.toOffer(request);
    }

}
