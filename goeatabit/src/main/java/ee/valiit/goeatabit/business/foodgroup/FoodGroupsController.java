package ee.valiit.goeatabit.business.foodgroup;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodGroupsController {

    @Resource
    private FoodGroupsService foodGroupsService;
    @GetMapping("/food-groups")
    @Operation(summary = "Tagastab nimekirja toitude kategooriatest.")
    public List<FoodGroupDto> getFoodGroups() {
        return foodGroupsService.getFoodGroups();
    }
}
