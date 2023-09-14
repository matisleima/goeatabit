package ee.valiit.goeatabit.domain.offer;

import ee.valiit.goeatabit.Offer;
import ee.valiit.goeatabit.util.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public List<Offer> getFilteredOffers(LocalDate date, Integer foodGroupId, String description, BigDecimal priceLimit) {
        return offerRepository.getFilteredOffersBy(date, foodGroupId, description, priceLimit, Status.ACTIVE.getLetter());
    }
}
