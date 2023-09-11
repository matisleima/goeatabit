package ee.valiit.goeatabit.business.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
    @Query("select o from Offer o where o.status = ?1")
    List<Offer> getOffersBy(String status);
}