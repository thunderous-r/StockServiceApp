package stockservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import stockservice.entity.PolygonStock;
import stockservice.repository.PolygonStockRepository;
import stockservice.service.PolygonStockService;

import java.util.List;

@RestController
@RequestMapping({"api/polygon-stocks", "api/polygon-stocks/"})
@RequiredArgsConstructor
public class PolygonStockController {
    private final PolygonStockService polygonStockService;
    private final PolygonStockRepository polygonStockRepository;

    @GetMapping
    public ResponseEntity<List<PolygonStock>> getAllPolygonStocks(@AuthenticationPrincipal UserDetails userDetails) {
        List<PolygonStock> stocks = polygonStockRepository.findByUserEmail(userDetails.getUsername());
        return ResponseEntity.ok(stocks);
    }

    @PostMapping
    public ResponseEntity<PolygonStock> savePolygonStock(@RequestBody PolygonStock polygonStock,
                                                         @AuthenticationPrincipal UserDetails userDetails) {
        PolygonStock savedStock = polygonStockService.savePolygonStock(polygonStock, userDetails.getUsername());
        return ResponseEntity.ok(savedStock);
    }

}
