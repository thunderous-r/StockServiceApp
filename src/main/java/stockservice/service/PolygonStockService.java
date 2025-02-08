package stockservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PolygonStockService {
    private final WebClient webClient;

    @Value("${spring.polygon.api-key}")
    private String apiKey;

    public PolygonStockService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<JsonNode> getStockPrice(String ticker) {
        return webClient.get()
                .uri("https://api.polygon.io/v2/aggs/ticker/{ticker}/prev", ticker)
                .header("Authorization", "Bearer " + apiKey)
                .retrieve()
                .bodyToMono(JsonNode.class);
    }
}
