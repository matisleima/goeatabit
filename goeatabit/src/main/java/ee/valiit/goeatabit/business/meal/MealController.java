package ee.valiit.goeatabit.business.meal;

import ee.valiit.goeatabit.business.dto.FilteredOffer;
import ee.valiit.goeatabit.business.dto.OfferDto;
import ee.valiit.goeatabit.business.meal.dto.FilteredOfferRequest;
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
                                                 @RequestParam BigDecimal priceLimit) {

        FilteredOfferRequest request = FilteredOfferRequest.builder()
                .districtId(districtId)
                .date(date.trim())
                .foodGroupId(foodGroupId)
                .description(description.trim())
                .priceLimit(priceLimit)
                .build();

        return mealService.getFilteredOffers(request);
    }

    @GetMapping("/offer")
    public OfferDto getOffer(@RequestParam Integer offerId, @RequestParam Integer userId) {
        return mealService.getOffer(offerId, userId);
    }

    @GetMapping("/offers")
    public List<OfferDto> getOffers() {
        return mealService.getOffers();
    }

    @PostMapping("/offers")
    public void addOffer(@RequestBody OfferDto request) {

        mealService.addOffer(request);
    }

}
