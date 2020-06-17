package response;

import lombok.Data;

@Data
public class UserToken {
    private String accessToken;
    private String expiresIn;
    private String tokenType;
}
