package ee.valiit.goeatabit.business.district;

import ee.valiit.goeatabit.business.district.dto.DistrictDto;
import ee.valiit.goeatabit.domain.district.District;
import ee.valiit.goeatabit.domain.district.DistrictMapper;
import ee.valiit.goeatabit.domain.district.DistrictService;
import ee.valiit.goeatabit.domain.location.Location;
import ee.valiit.goeatabit.domain.location.LocationMapper;
import ee.valiit.goeatabit.domain.location.LocationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictsService {
    @Resource
    private DistrictService districtService;
    @Resource
    private DistrictMapper districtMapper;
    @Resource
    private LocationService locationService;

    public List<DistrictDto> getDistricts() {
        List<District> districts = districtService.getDistricts();
        List<DistrictDto> districtDtos = districtMapper.toDistrictDtos(districts);
        return districtDtos;
    }

    public String getDistrict(Integer userId) {
        Location location = locationService.getLocationBy(userId);
        String districtName = location.getDistrict().getName().toUpperCase();
        return districtName;

    }
}
