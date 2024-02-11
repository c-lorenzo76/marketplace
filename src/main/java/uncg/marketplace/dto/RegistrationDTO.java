package uncg.marketplace.dto;

import lombok.Data;
import uncg.marketplace.entity.user.UserType;

@Data
public class RegistrationDTO {
    private String name;
    private String email;
    private String password;
    private UserType userType;

}
