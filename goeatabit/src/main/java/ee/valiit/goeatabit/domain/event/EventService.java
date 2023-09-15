package ee.valiit.goeatabit.domain.event;

import ee.valiit.goeatabit.domain.offer.Offer;
import ee.valiit.goeatabit.domain.user.User;
import ee.valiit.goeatabit.validation.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Resource
    private EventRepository eventRepository;


    public void addEvent(Offer offer, User user) {
        Event event = new Event();
        event.setOffer(offer);
        event.setUser(user);
        event.setStatus(Status.ACTIVE.getLetter());
        eventRepository.save(event);
    }
}
