package ee.valiit.goeatabit.domain.rating;

import ee.valiit.goeatabit.domain.rating.Rating;
import ee.valiit.goeatabit.domain.rating.RatingRepository;
import ee.valiit.goeatabit.domain.user.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Resource
    private RatingRepository ratingRepository;

    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }
}
