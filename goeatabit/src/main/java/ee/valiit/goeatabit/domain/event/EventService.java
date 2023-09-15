package ee.valiit.goeatabit.domain.event;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Resource
    private EventRepository eventRepository;


    public void saveEvent(Event event) {
        eventRepository.save(event);
    }
}
