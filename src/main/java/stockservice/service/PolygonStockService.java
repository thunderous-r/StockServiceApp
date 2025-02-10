package stockservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import stockservice.entity.PolygonStock;
import stockservice.entity.User;

@Service
public class PolygonStockService {
    private final WebClient webClient;

    @Value("${spring.polygon.api-key}")
    private String apiKey;

    public PolygonStockService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.polygon.io").build();
    }

    public Mono<JsonNode> getStockPrice(String ticker) {
        return webClient.get()
                .uri("/v2/aggs/ticker/" + ticker + "/prev?apiKey=" + apiKey)
                .retrieve()
                .bodyToMono(JsonNode.class);
    }

    public PolygonStock savePolygonStock(PolygonStock polygonStock, String email) {
        return null; //TODO
    }
}
