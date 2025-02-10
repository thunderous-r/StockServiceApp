package stockservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "polygon_stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PolygonStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ticker;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
