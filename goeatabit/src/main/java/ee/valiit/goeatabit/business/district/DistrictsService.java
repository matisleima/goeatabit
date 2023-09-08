package ee.valiit.goeatabit.business.district;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class DistrictsService {

    @Resource
    private DistrictService districtService;

    @Resource
    private DistrictMapper districtMapper;


    public List<DistrictDto> getDistricts() {
        List<District> districts = districtService.getDistricts();
        List<DistrictDto> districtDtos = districtMapper.toDistrictDtos(districts);
        return districtDtos;
    }
}
