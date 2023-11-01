package ee.valiit.goeatabit.business.meal;


import ee.valiit.goeatabit.business.meal.dto.EventDto;
import ee.valiit.goeatabit.business.meal.dto.FilteredOfferRequest;
import ee.valiit.goeatabit.business.meal.dto.offer.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Resource
    private MealService mealService;


    @PostMapping("/offer")
    @Operation(summary = "Lisab andmebaasi uue pakkumise.")
    public void addOffer(@RequestBody OfferDto request) {
        mealService.addOffer(request);
    }

    @GetMapping("/offer")
    @Operation(summary = "Tagastab ühe pakkumise andmed.")
    public OfferInfo getOfferInfo(@RequestParam Integer offerId) {
        return mealService.getOfferInfo(offerId);
    }

    @PutMapping("/offer")
    @Operation(summary = "Uuendab ühe pakkumise andmeid.")
    public void updateOffer(@RequestParam Integer offerId, @RequestBody OfferInfo request) {
        mealService.updateOffer(offerId, request);
    }

    @DeleteMapping("/offer")
    @Operation(summary = "Muudab valitud pakkumise staatust.")
    public void deleteOffer(@RequestParam Integer offerId) {
        mealService.deleteOffer(offerId);
    }

    @GetMapping("/filtered-offers")
    @Operation(summary = "Tagastab filtreeritud nimekirja pakkumistest, filtrite puudumisel kõik pakkumised.")
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

    @GetMapping("/offer/booking/confirmation-info")
    @Operation(summary = "Tagastab pakkumise lühiinfo pakkumise kinnitamise jaoks.")
    public BookingConfirmationInfo getOfferBasicInfo(@RequestParam Integer offerId) {
        return mealService.getOfferBasicInfo(offerId);
    }
    @GetMapping("/offers/last-3")
    @Operation(summary = "Tagastab 3 viimati andmebaasi lisatud pakkumist.")
    public List<LatestOffer> getLastThreeOffers() {
        return mealService.getLastThreeOffers();
    }

    @GetMapping("/offers/hot-3")
    @Operation(summary = "Tagastab 3 varaseimat pakkumist kasutaja linnaosas.")
    public List<NextHotOffer> getNextHotThreeOffers(@RequestParam Integer userId) {
        return mealService.getNextHotThreeOffers(userId);
    }
    @PostMapping("/event")
    @Operation(summary = "Lisab andmebaasi uue broneeringu (event), sidudes pakkumise ja kliendi andmed.")
    public void addReservation(@RequestParam Integer offerId, @RequestParam Integer userId) {
        mealService.addEvent(offerId, userId);
    }
    @GetMapping("/events")
    @Operation(summary = "Tagastab kõik ühe kasutajaga seotud broneeringud.")
    public List<EventDto> getMyEvents(@RequestParam Integer userId) {
        return mealService.getMyEvents(userId);
    }

    @DeleteMapping("/event")
    @Operation(summary = "Muudab valitud broneeringu staatust.")
    public void deleteEvent(@RequestParam Integer eventId) {
        mealService.deleteEvent(eventId);
    }
}