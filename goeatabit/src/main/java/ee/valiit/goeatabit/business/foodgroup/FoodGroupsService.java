package ee.valiit.goeatabit.business.foodgroup;

import ee.valiit.goeatabit.domain.foodgroup.FoodGroup;
import ee.valiit.goeatabit.domain.foodgroup.FoodGroupMapper;
import ee.valiit.goeatabit.domain.foodgroup.FoodGroupService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodGroupsService {
    @Resource
    private FoodGroupService foodGroupService;
    @Resource
    private FoodGroupMapper foodGroupMapper;

    public List<FoodGroupDto> getFoodGroups() {
        List<FoodGroup> foodGroups = foodGroupService.findAllFoodGroups();
        return foodGroupMapper.toFoodGroupDtos(foodGroups);
    }

    public FoodGroup getFoodGroupBy(Integer foodGroupId) {
        return foodGroupService.getFoodGroupBy(foodGroupId);
    }
}
