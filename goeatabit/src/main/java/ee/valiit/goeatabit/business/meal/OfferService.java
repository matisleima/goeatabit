package ee.valiit.goeatabit.business.meal;

import ee.valiit.goeatabit.util.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Resource
    private OfferRepository offerRepository;
    public List<Offer> getActiveOffers() {
        return offerRepository.getOffersBy(Status.ACTIVE.getLetter());
    }
}
