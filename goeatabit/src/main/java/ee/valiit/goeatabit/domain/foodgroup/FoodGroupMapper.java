package ee.valiit.goeatabit.domain.foodgroup;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FoodGroupMapper {

    @Mapping(source = "id", target = "foodGroupId")
    @Mapping(source = "name", target = "foodGroupName")
    FoodGroupDto toFoodGroupDto(FoodGroup foodGroup);

    List<FoodGroupDto> toFoodGroupDtos(List<FoodGroup> foodGroups);
}