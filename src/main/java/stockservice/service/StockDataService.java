package stockservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import stockservice.entity.StockData;
import stockservice.entity.User;
import stockservice.repository.StockDataRepository;

import java.util.List;

@Service
public class StockDataService {
    private final StockDataRepository stockDataRepository;
    private final PolygonStockService polygonStockService;
    private final UserService userService;

    public StockDataService(StockDataRepository stockDataRepository, PolygonStockService polygonStockService, UserService userService) {
        this.stockDataRepository = stockDataRepository;
        this.polygonStockService = polygonStockService;
        this.userService = userService;
    }

    public List<StockData> getAllStockData() {
        return stockDataRepository.findAll();
    }

    public List<StockData> getStockDataByTicker(String ticker) {
        return stockDataRepository.findAll().stream()
                .filter(stock -> stock.getTicker().equalsIgnoreCase(ticker))
                .toList();
    }

    public StockData saveStockData(StockData stockData) {
        User user = userService.findUserByEmail(stockData.getUser().getEmail());
        return stockDataRepository.save(stockData);
    }

    public void deleteStockData(Long id) {
        stockDataRepository.deleteById(id);
    }

    public Mono<JsonNode> fetchLatestStockPrice(String ticker) {
        return polygonStockService.getStockPrice(ticker);
    }
}
