package ee.valiit.goeatabit.domain.offer;

import ee.valiit.goeatabit.business.meal.dto.FilteredOfferRequest;
import ee.valiit.goeatabit.util.DateConverter;
import ee.valiit.goeatabit.validation.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OfferService {
    @Resource
    private OfferRepository offerRepository;

    public List<Offer> getFilteredOffers(FilteredOfferRequest request) {
        String today = LocalDate.now().toString();
        Integer result = today.compareTo(request.getDate());
        return offerRepository.getFilteredOffersBy(request.getFoodGroupId(),
                request.getDistrictId(),
                request.getPriceLimit(),
                Status.ACTIVE.getLetter(),
                request.getDescription(),
                request.getDate(),
                request.getUserId(),
                result);
    }

    public List<Offer> getLastThreeActiveOffers() {
        return offerRepository.getLastThreeOffers(Status.ACTIVE.getLetter());
    }

    public List<Offer> getNextTodaysThreeActiveOffersBy(Integer districtId) {
        String today = LocalDate.now().toString();
        return offerRepository.getNextTodaysThreeOffersBy(Status.ACTIVE.getLetter(), districtId, today);
    }

    public void saveOffer(Offer offer) {
        offerRepository.save(offer);
    }

    public Offer getOfferBy(Integer offerId) {
        return offerRepository.getReferenceById(offerId);
    }
}