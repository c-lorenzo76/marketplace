package uncg.marketplace.service.user;

import uncg.marketplace.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceMethods {

    void addUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void updateUser(User user);
    void saveUser(User user);
    void deleteUserById(Long id);



}
