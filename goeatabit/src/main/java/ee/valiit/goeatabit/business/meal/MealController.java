package ee.valiit.goeatabit.business.meal;

import ee.valiit.goeatabit.domain.offer.OfferDto;
import ee.valiit.goeatabit.domain.offer.OfferFilterDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/offers")
    public void getFilteredOffers(@RequestBody OfferFilterDto offerFilterDto) {
        mealService.getFilteredOffers(offerFilterDto);
    }
}
