package ee.valiit.goeatabit.domain.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

    @Query("select o from Offer o where o.status = ?1 order by o.id desc limit 3")
    List<Offer> getLastThreeOffers(String status);

    @Query("select o from Offer o where o.status = ?1 and o.location.district.id = ?2 and o.date >= ?3 order by o.date, o.time limit 3")
    List<Offer> getNextTodaysThreeOffersBy(String status, Integer districtId, String today);

    @Query("""
            select o from Offer o
            where (o.foodGroup.id = ?1 or ?1 = 0)
            and (o.location.district.id = ?2 or ?2 = 0)
            and (o.price <= ?3 or ?3 = 0)
            and o.status = ?4
            and (lower(o.description) LIKE CONCAT('%', lower(?5), '%') or ?5 = '')
            and (o.date = ?6 or ?6 = '' and ?8 >= 0)
            and (o.user.id = ?7 or ?7 = 0) order by o.date, o.time
            """)
    List<Offer> getFilteredOffersBy(Integer foodGroupId, Integer districtId, BigDecimal priceLimit, String status,
                                    String description, String date, Integer userId, Integer result);

    @Query("select o from Offer o where o.id = ?1 and o.status = ?2")
    Offer getActiveOfferBy(Integer offerId, String status);
}