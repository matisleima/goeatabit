package ee.valiit.goeatabit.business.meal;

import ee.valiit.goeatabit.domain.offer.OfferDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    //        @GetMapping("/offers")
//    public void getFilteredOffers(@RequestBody OfferFilterDto offerFilterDto) {
//        mealService.getFilteredOffers(offerFilterDto);
//    }
    @PostMapping("/offers")
    public void addOffer(@RequestBody OfferDto request) {

        mealService.addOffer(request);
    }

}
