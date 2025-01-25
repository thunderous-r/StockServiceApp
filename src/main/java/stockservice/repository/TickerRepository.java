package stockservice.repository;

import stockservice.entity.StockData;
import stockservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TickerRepository extends JpaRepository<StockData, Long> {
    List<StockData> findByUserAndTicker(User user, String ticker);
}
