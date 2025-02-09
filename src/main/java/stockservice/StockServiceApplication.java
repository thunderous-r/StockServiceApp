package stockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockServiceApplication {
    public static void main(String[] args) {
        System.setProperty("logging.level.org.springframework.security", "DEBUG");
        SpringApplication.run(StockServiceApplication.class, args);
    }
}
