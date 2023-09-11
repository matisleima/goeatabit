package ee.valiit.goeatabit.business.meal;

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
    @Mapping(source = "totalPortions", target = "totalPortions")
    @Mapping(source = "name", target = "offerName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "foodGroup.id", target = "foodGroupId")
    @Mapping(source = "status", target = "offerStatus")
    OfferDto toOfferDto(Offer offer);

    List<OfferDto> toOfferDtos(List<Offer> offers);


}