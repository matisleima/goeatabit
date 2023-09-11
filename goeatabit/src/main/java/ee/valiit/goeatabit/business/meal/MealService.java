package ee.valiit.goeatabit.business.meal;

import ee.valiit.goeatabit.domain.location.Location;
import ee.valiit.goeatabit.domain.location.LocationMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Resource
    private OfferService offerService;
    @Resource
    private OfferMapper offerMapper;

    @Resource
    private LocationMapper locationMapper;

    public List<OfferDto> getOffers() {
        //todo: päri offer tabelist userId
        //todo: päri userId järgi location tabelist address ja districtId
        //todo: lisa need offerDto külge
        locationMapper.toOfferDto(location);


        List<Offer> activeOffers = offerService.getActiveOffers();
        return offerMapper.toOfferDtos(activeOffers);
    }
}
