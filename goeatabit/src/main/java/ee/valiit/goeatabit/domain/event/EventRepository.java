package ee.valiit.goeatabit.domain.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.user.id = ?1 and e.status = ?2 order by e.offer.date, e.offer.time")
    List<Event> getActiveEventsBy(Integer userId, String letter);

    @Query("select e from Event e where e.id = ?1")
    Event getEventby(Integer eventId);

    @Query("select count(e) from Event e where e.offer.id = ?1 and e.status = ?2")
    long getEventsCountBy(Integer offerId, String status);
}