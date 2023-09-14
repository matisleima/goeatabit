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
    public static final String DATE_TO_INCLUCE_ALL_DATES = "1984-05-04";
    @Resource
    private OfferRepository offerRepository;

    public List<Offer> getFilteredOffers(FilteredOfferRequest request) {
        LocalDate localDate;

        if (hasDate(request)) {
            localDate = DateConverter.stringToLocalDate(request.getDate());
        } else {
            localDate = DateConverter.stringToLocalDate(DATE_TO_INCLUCE_ALL_DATES);
        }
        return offerRepository.getFilteredOffersBy(request.getFoodGroupId(), request.getDistrictId(), request.getPriceLimit(), Status.ACTIVE.getLetter(), request.getDescription(), localDate);

    }

    private static boolean hasDate(FilteredOfferRequest request) {
        return !request.getDate().isBlank();
    }

    public List<Offer> getActiveOffers() {
        List<Offer> activeOffers = offerRepository.getOffersBy(Status.ACTIVE.getLetter());
        return activeOffers;
    }



    public void saveOffer(Offer offer) {
        offerRepository.save(offer);
    }
}
