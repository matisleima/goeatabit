package ee.valiit.goeatabit.business.meal;

import ee.valiit.goeatabit.domain.location.Location;
import ee.valiit.goeatabit.domain.location.LocationService;
import ee.valiit.goeatabit.domain.offer.Offer;
import ee.valiit.goeatabit.domain.offer.OfferDto;
import ee.valiit.goeatabit.domain.offer.OfferMapper;
import ee.valiit.goeatabit.domain.offer.OfferService;
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
    private OfferMapper offerMapper;

    public List<OfferDto> getOffers() {
        List<Offer> activeOffers = offerService.getActiveOffers();
        List<OfferDto> offerDtos = offerMapper.toOfferDtos(activeOffers);
        addLocationInfoToOfferDtos(offerDtos);
        return offerDtos;
    }

    private void addLocationInfoToOfferDtos(List<OfferDto> offerDtos) {
        for (OfferDto offerDto : offerDtos) {
            Location location = locationService.getLocationBy(offerDto.getUserId());
            offerDto.setAddress(location.getAddress());
            offerDto.setDistrictId(location.getDistrict().getId());
        }
    }

}
