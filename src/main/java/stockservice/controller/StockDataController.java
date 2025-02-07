package stockservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stockservice.entity.StockData;
import stockservice.service.StockDataService;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockDataController {
    private final StockDataService stockDataService;
    public StockDataController(StockDataService stockDataService) {
        this.stockDataService = stockDataService;
    }

    @GetMapping
    public List<StockData> getAllStocks() {
        return stockDataService.getAllStockData();
    }

    @GetMapping("/{ticker}")
    public List<StockData> getStocksByTicker(@PathVariable String ticker) {
        return stockDataService.getStockDataByTicker(ticker);
    }

    @PostMapping
    public ResponseEntity<StockData> addStock(@RequestBody StockData stockData) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stockDataService.saveStockData(stockData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable Long id) {
        stockDataService.deleteStockData(id);
        return ResponseEntity.ok().build();
    }
}
