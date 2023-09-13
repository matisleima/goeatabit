package ee.valiit.goeatabit.domain.foodgroup;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodGroupController {

    @Resource
    private FoodGroupService foodGroupService;
    @GetMapping("/food-groups")
    public List<FoodGroupDto> getFoodGroups() {
        return foodGroupService.getFoodGroups();
    }
}
