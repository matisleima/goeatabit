package ee.valiit.goeatabit.domain.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("select l from Location l where l.user.id = ?1")
    Location getLocationBy(Integer userId);

}