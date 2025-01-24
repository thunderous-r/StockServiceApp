package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "stock_data")
public class StockData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ticker;

    @Column(nullable = false)
    private LocalDate date;

    private Double open;
    private Double close;
    private Double high;
    private Double low;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //getters setters
}
