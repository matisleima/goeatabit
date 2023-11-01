package ee.valiit.goeatabit.business.district;

import ee.valiit.goeatabit.business.district.dto.DistrictDto;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Tagastab nimekirja linnaosadest.")
    public List<DistrictDto> getDistricts() {
        List<DistrictDto> districts = districtsService.getDistricts();
        return districts;
    }

    @GetMapping("/district")
    @Operation(summary = "Tagastab sisseloginud kasutaja linnaosa.")
    public String getDistrict(@RequestParam Integer userId) {
        return districtsService.getDistrict(userId);
    }
}





