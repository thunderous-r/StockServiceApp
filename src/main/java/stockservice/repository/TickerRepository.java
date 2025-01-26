package stockservice.repository;

import stockservice.entity.StockData;
import stockservice.entity.Ticker;
import stockservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TickerRepository extends JpaRepository<Ticker, Long> {

    Optional<Ticker> findBySymbol(String symbol);
}
