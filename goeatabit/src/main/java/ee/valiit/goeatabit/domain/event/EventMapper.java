package ee.valiit.goeatabit.domain.event;

import ee.valiit.goeatabit.business.meal.dto.EventDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {


    @Mapping(source = "id", target = "eventId")
    @Mapping(source = "user.id", target = "clientUserId")
    @Mapping(source = "offer.id", target = "offerId")
    @Mapping(source = "offer.user.id", target = "offerUserId")
    @Mapping(source = "offer.user.rating", target = "offerUserRating")
    @Mapping(source = "offer.time", target = "offerTime")
    @Mapping(source = "offer.date", target = "offerDate")
    @Mapping(source = "offer.price", target = "offerPrice")
    @Mapping(source = "offer.totalPortions", target = "offerTotalPortions")
    @Mapping(source = "offer.name", target = "offerName")
    @Mapping(source = "offer.description", target = "offerDescription")
    @Mapping(source = "offer.status", target = "offerStatus")
    @Mapping(source = "status", target = "eventStatus")
    EventDto toEventDto(Event event);

    List<EventDto> toEventDtos(EventDto eventDto);
}