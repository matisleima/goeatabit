package ee.valiit.goeatabit.domain.foodgroup;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodGroupService {
    @Resource
    private FoodGroupRepository foodGroupRepository;
    @Resource
    private FoodGroupMapper foodGroupMapper;
    public List<FoodGroupDto> getFoodGroups() {
        List<FoodGroup> foodGroups = foodGroupRepository.findAll();
        List<FoodGroupDto> foodGroupDtos = foodGroupMapper.toFoodGroupDtos(foodGroups);
        return foodGroupDtos;
    }
}
