package stockservice.service;

import org.springframework.stereotype.Service;
import stockservice.entity.StockData;
import stockservice.repository.StockDataRepository;

import java.util.List;

@Service
public class StockDataService {
    private final StockDataRepository stockDataRepository;
    public StockDataService(StockDataRepository stockDataRepository) {
        this.stockDataRepository = stockDataRepository;
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
        return stockDataRepository.save(stockData);
    }

    public void deleteStockData(Long id) {
        stockDataRepository.deleteById(id);
    }
}
