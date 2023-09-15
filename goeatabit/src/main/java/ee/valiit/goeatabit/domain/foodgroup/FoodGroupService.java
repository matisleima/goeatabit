package ee.valiit.goeatabit.domain.foodgroup;

import jakarta.annotation.Resource;

import java.util.List;

@Resource
public class FoodGroupService {

    @Resource
    private FoodGroupRepository foodGroupRepository;

    public List<FoodGroup> findAllFoodGroups() {
        return foodGroupRepository.findAll();
    }

    public FoodGroup getFoodGroupBy(Integer foodGroupId) {
        return foodGroupRepository.getReferenceById(foodGroupId);
    }

}
