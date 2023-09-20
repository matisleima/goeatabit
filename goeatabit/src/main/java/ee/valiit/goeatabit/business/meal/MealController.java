package ee.valiit.goeatabit.business.meal;


import ee.valiit.goeatabit.business.meal.dto.EventDto;
import ee.valiit.goeatabit.business.meal.dto.FilteredOfferRequest;
import ee.valiit.goeatabit.business.offer.dto.FilteredOffer;
import ee.valiit.goeatabit.business.offer.dto.LatestOffer;
import ee.valiit.goeatabit.business.offer.dto.NextHotOffer;
import ee.valiit.goeatabit.business.offer.dto.OfferDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Resource
    private MealService mealService;

    @GetMapping("/filtered-offers")
    public List<FilteredOffer> getFilteredOffers(@RequestParam Integer districtId,
                                                 @RequestParam String date,
                                                 @RequestParam Integer foodGroupId,
                                                 @RequestParam String description,
                                                 @RequestParam BigDecimal priceLimit,
                                                 @RequestParam Integer userId) { //see on pakkuja ID

        FilteredOfferRequest request = FilteredOfferRequest.builder()
                .districtId(districtId)
                .date(date.trim())
                .foodGroupId(foodGroupId)
                .description(description.trim())
                .priceLimit(priceLimit)
                .userId(userId)
                .build();

        return mealService.getFilteredOffers(request);
    }

    @PostMapping("/offer")
    public void addOffer(@RequestBody OfferDto request) {
        mealService.addOffer(request);
    }

    @GetMapping("/offer")
    public OfferDto getOffer(@RequestParam Integer offerId, @RequestParam Integer userId) {
        return mealService.getOffer(offerId, userId);
    }
    @PutMapping("/offer")
    public void updateOffer(@RequestParam Integer offerId, @RequestBody OfferDto request) {
        mealService.updateOffer(offerId, request);
    }

    @DeleteMapping("/offer")
    public void deleteOffer(@RequestParam Integer offerId) {
        mealService.deleteOffer(offerId);
    }

    @GetMapping("/offers/last-3")
    public List<LatestOffer> getLastThreeOffers() {
        return mealService.getLastThreeOffers();
    }

    @GetMapping("/offers/hot-3")
    public List<NextHotOffer> getNextHotThreeOffers(@RequestParam Integer userId) {
        return mealService.getNextHotThreeOffers(userId);
    }
    @PostMapping("/event")
    public void addReservation(@RequestParam Integer offerId, @RequestParam Integer userId) {
        mealService.addEvent(offerId, userId);
    }
    @GetMapping("/events")
    public List<EventDto> getMyEvents(@RequestParam Integer userId) {
        return mealService.getMyEvents(userId);
    }

}
