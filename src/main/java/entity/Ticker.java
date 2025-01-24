package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tickers")
public class Ticker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String symbol;;

    private String name;

    // Getters and setters
}
