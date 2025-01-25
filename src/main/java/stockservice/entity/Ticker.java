package stockservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tickers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Ticker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String symbol;;

    private String name;

}
