package stockservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JwtClaimsDTO {
    private String username;
    private Date expiration;
}
