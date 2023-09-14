package ee.valiit.goeatabit.domain.offer;

import ee.valiit.goeatabit.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
    @Query("""
            select o from Offer o
            where (o.date = ?1 or ?1 is null) 
            and (o.foodGroup.id = ?2 or ?2 is null)
            and (o.description LIKE CONCAT('%', ?4, '%') or ?3 is null)
            and (o.price = ?4 or ?4 is null)
            and o.status = ?5
            """)
    List<Offer> getFilteredOffersBy(LocalDate date, Integer id, String description, BigDecimal price, String status);




    @Query("select o from Offer o where o.status = ?1 order by o.date")
    List<Offer> getOffersBy(String status);
}