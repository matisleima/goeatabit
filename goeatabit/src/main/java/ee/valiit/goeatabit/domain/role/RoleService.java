package ee.valiit.goeatabit.domain.role;

import ee.valiit.goeatabit.domain.role.Role;
import ee.valiit.goeatabit.domain.role.RoleRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;
    public Role getRole(String roleName) {

        return roleRepository.getRoleBy(roleName);
    }
}
