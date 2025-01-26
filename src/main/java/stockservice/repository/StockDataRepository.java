package stockservice.repository;

import stockservice.entity.StockData;
import stockservice.entity.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import stockservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface StockDataRepository extends JpaRepository<StockData, Long> {
    List<StockData> findByUserAndTicker(User user, String ticker);
}
