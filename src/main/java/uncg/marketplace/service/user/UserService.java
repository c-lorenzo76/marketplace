package uncg.marketplace.service.user;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uncg.marketplace.dto.RegisterDTO;
import uncg.marketplace.dto.UserDTO;
import uncg.marketplace.entity.user.User;
import uncg.marketplace.entity.user.UserRole;
import uncg.marketplace.util.MapperConfig;
import uncg.marketplace.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceMethods {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapperConfig modelMapper;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    // ADMIN //
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    // ADMIN //
    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public UserDTO registerUser(RegisterDTO registerDTO){
        User user = modelMapper.convertRegisterDtoToUser(registerDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        Optional<User> newUser = userRepository.findByEmail(user.getEmail());
        if(newUser.isPresent()){
            User userCreated = newUser.get();
            return modelMapper.convertUserToUserDto(userCreated);
        }
        else{
            return null;
        }

    }



}
