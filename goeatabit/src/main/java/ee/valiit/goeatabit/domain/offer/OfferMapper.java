package ee.valiit.goeatabit.domain.offer;

import ee.valiit.goeatabit.business.offer.dto.FilteredOffer;
import ee.valiit.goeatabit.business.offer.dto.LatestOffer;
import ee.valiit.goeatabit.business.offer.dto.NextHotOffer;
import ee.valiit.goeatabit.business.offer.dto.OfferDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OfferMapper {

    @Mapping(source = "id", target = "offerId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.rating", target = "userRating")
    @Mapping(source = "time", target = "time")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "name", target = "offerName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "location.address", target = "address")
    FilteredOffer toFilteredOffer(Offer offer);

    List<FilteredOffer> toFilteredOffers(List<Offer> offer);


    @Mapping(source = "id", target = "offerId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.rating", target = "userRating")
    @Mapping(source = "time", target = "time")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "totalPortions", target = "totalPortions")
    @Mapping(source = "name", target = "offerName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "foodGroup.id", target = "foodGroupId")
    @Mapping(source = "status", target = "offerStatus")
    OfferDto toOfferDto(Offer offer);

    List<OfferDto> toOfferDtos(List<Offer> offers);


    @Mapping(source = "id", target = "offerId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "name", target = "offerName")
    LatestOffer toLatestOffer(Offer offer);

 List   <LatestOffer> toLatestOffers(List <Offer> offers);




    @Mapping(source = "time", target = "time")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "totalPortions", target = "totalPortions")
    @Mapping(source = "offerName", target = "name")
    @Mapping(source = "description", target = "description")
    Offer toOffer(OfferDto request);


    @Mapping(source = "id", target = "offerId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "name", target = "offerName")
    @Mapping(source = "time", target = "time", qualifiedByName = "timeIntegerToString")
    NextHotOffer toNextHotOffer(Offer offer);

    List<NextHotOffer> toNextHotOffers(List<Offer> offers);


    @Named("timeIntegerToString")
    static String timeIntegerToString(Integer time) {
        return time + ":00";
    }

}