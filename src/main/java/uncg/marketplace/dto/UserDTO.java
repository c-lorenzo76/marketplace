package uncg.marketplace.dto;


import lombok.Data;
import uncg.marketplace.entity.user.UserType;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private UserType userType;
}
