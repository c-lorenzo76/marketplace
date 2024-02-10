package uncg.marketplace.service.user;

import uncg.marketplace.dto.UserDTO;
import uncg.marketplace.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceMethods {

    void addUser(User user);
    List<User> getAllUsers();
    // this would be for admin search
    Optional<User> getUserById(Long id);
    // this would be for getting details for user such as for listing
    // UserDTO getUserDetails(Long userId);
    void updateUser(User user);
    void saveUser(User user);
    void deleteUserById(Long id);
    UserDTO convertEntityToDto(User user);
    User convertDtoToEntity(UserDTO userDTO);


}
