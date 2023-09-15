package ee.valiit.goeatabit.domain.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.user.id = ?1")
    List<Event> getEventsBy(Integer userId);
}