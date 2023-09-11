package ee.valiit.goeatabit.domain.district;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Resource
    private DistrictRepository districtRepository;

    public List<District> getDistricts() {
        List<District> districts = districtRepository.findAll();
        return districts;
    }

    public District getDistrictBy(Integer districtId) {
        return districtRepository.getReferenceById(districtId);
    }

}
