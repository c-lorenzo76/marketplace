package uncg.marketplace.dto;

import lombok.Data;
import uncg.marketplace.entity.user.UserRole;
import uncg.marketplace.entity.user.UserType;

@Data
public class RegisterDTO {
    private String name;
    private String email;
    private String password;
    private UserType userType;

}
