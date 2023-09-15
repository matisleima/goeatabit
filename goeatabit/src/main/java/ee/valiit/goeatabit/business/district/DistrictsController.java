package ee.valiit.goeatabit.business.district;

import ee.valiit.goeatabit.business.district.dto.DistrictDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DistrictsController {

    @Resource
    private DistrictsService districtsService;

    @GetMapping("/districts")

    public List<DistrictDto> getDistricts() {
        List<DistrictDto> districts = districtsService.getDistricts();
        return districts;
    }

    @GetMapping("/district")
    public DistrictDto getDistrict(@RequestParam Integer userId) {
        return districtsService.getDistrict(userId);
    }
}





