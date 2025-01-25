package stockservice.repository;

import stockservice.entity.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockDataRepository extends JpaRepository<Ticker, Long> {
    Optional<Ticker> findBySymbol(String symbol);
}
