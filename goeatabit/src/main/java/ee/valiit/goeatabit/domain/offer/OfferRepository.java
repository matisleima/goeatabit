package ee.valiit.goeatabit.domain.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
    @Query("select o from Offer o where o.status = ?1 order by o.date")
    List<Offer> getOffersBy(String status);
}