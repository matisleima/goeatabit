package ee.valiit.goeatabit.business.meal;

import ee.valiit.goeatabit.domain.contact.Contact;
import ee.valiit.goeatabit.domain.contact.ContactService;
import ee.valiit.goeatabit.domain.location.Location;
import ee.valiit.goeatabit.domain.location.LocationService;
import ee.valiit.goeatabit.domain.offer.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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

    public List<OfferDto> getOffers() {
        List<Offer> activeOffers = offerService.getActiveOffers();
        List<OfferDto> offerDtos = offerMapper.toOfferDtos(activeOffers);
        addLocationInfoToOfferDtos(offerDtos);
        addContactInfoToOfferDtos(offerDtos);
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

    public void getFilteredOffers(OfferFilterDto offerFilterDto) {
        offerService.getFilteredOffers(offerFilterDto);
    }
}
