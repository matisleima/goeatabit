package ee.valiit.goeatabit.business.meal;

import ee.valiit.goeatabit.domain.offer.dto.OfferDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Resource
    private MealService mealService;

    @GetMapping("/offers")
    public List<OfferDto> getOffers() {
        return mealService.getOffers();
    }

    @GetMapping("/filtered-offers")
    public List<OfferDto> getFilteredOffers(@RequestParam Integer districtId,
                                            @RequestParam LocalDate date,
                                            @RequestParam Integer foodGroupId,
                                            @RequestParam String description,
                                            @RequestParam BigDecimal priceLimit,
                                            @RequestParam Integer userId) {
        return mealService.getFilteredOffers(districtId, date, foodGroupId, description, priceLimit, userId);
    }

    @PostMapping("/offers")
    public void addOffer(@RequestBody OfferDto request) {
        mealService.addOffer(request);
    }

}
