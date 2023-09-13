package ee.valiit.goeatabit.domain.image;

import ee.valiit.goeatabit.domain.foodgroup.FoodGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "image", schema = "eat")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "data", nullable = false)
    private byte[] data;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_group_id")
    private FoodGroup foodGroup;

}