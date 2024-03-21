package uncg.marketplace.service.user;


import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uncg.marketplace.dto.RegisterDTO;
import uncg.marketplace.dto.UserDTO;
import uncg.marketplace.entity.user.User;
import uncg.marketplace.entity.user.UserRole;
import uncg.marketplace.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceMethods {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
    public Optional<User> signUpUser(RegistrationDTO registrationDTO){
        boolean userExists = app


        return "";
    }
    */

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
        User user = convertRegisterDtoToUser(registerDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        Optional<User> newUser = userRepository.findByEmail(user.getEmail());
        if(newUser.isPresent()){
            User userCreated = newUser.get();
            return convertEntityToDto(userCreated);
        }
        else{
            return null;
        }

    }

    // REGISTER
    /*
    public User convertRegistrationDtoToEntity(RegistrationDTO registrationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user;
        user = modelMapper.map(registrationDTO, User.class);
        user.setPassword(user.getPassword());
        user.setRole(UserRole.USER);
        user.setEnabled(false);

        return user;
    }
    */


    public User convertRegisterDtoToUser(RegisterDTO registerDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user;
        user = modelMapper.map(registerDTO, User.class);
        user.setRole(UserRole.USER);
        return user;
    }



    /**
     * ADMIN ONLY
     * Converts User to UserDTO,
     * Purpose is to convert user entity to userDto
     * @param user
     * @return userDTO
     */
    public UserDTO convertEntityToDto(User user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserDTO userDTO;
        userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    /**
     * ADMIN ONLY
     * Converts UserDTO to User,
     * Purpose is to display only necessary params from User.
     *
     * @param userDTO Necessary fields for listing from user
     * @return user
     */
    public User convertDtoToEntity(UserDTO userDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user;
        user = modelMapper.map(userDTO, User.class);
        return user;
    }

}
