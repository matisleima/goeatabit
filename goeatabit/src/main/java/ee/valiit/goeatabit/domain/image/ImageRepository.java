package ee.valiit.goeatabit.domain.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("select i from Image i where i.id = ?1")
    Image getImageStringBy(Integer id);


}