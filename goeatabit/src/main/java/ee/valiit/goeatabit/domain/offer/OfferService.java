package ee.valiit.goeatabit.domain.offer;

import ee.valiit.goeatabit.util.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    @Resource
    private OfferRepository offerRepository;

    public List<Offer> getActiveOffers() {
        List<Offer> activeOffers = offerRepository.getOffersBy(Status.ACTIVE.getLetter());
        return activeOffers;
    }

    public void saveOffer(Offer offer) {
        offerRepository.save(offer);
    }

//    public void getFilteredOffers(OfferFilterDto offerFilterDto) {
//
//    }
}
