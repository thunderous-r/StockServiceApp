package stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stockservice.entity.PolygonStock;

import java.util.List;

public interface PolygonStockRepository extends JpaRepository<PolygonStock, Long> {
    List<PolygonStock> findByUserEmail(String email);
}
