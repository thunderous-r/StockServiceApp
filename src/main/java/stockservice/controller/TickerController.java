package stockservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stockservice.entity.Ticker;
import stockservice.repository.TickerRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tickers")
public class TickerController {
    private final TickerRepository tickerRepository;

    public TickerController(TickerRepository tickerRepository) {
        this.tickerRepository = tickerRepository;
    }

    @GetMapping
    public List<Ticker> getAllTickers() {
        return tickerRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> addTicker(@RequestBody Ticker ticker) {
        if (tickerRepository.findBySymbol(ticker.getSymbol()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", "Ticker with symbol " + ticker.getSymbol() + " already exists"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tickerRepository.save(ticker));
    }
}
