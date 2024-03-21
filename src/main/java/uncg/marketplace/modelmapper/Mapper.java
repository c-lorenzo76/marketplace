package uncg.marketplace.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import uncg.marketplace.dto.RegisterDTO;
import uncg.marketplace.entity.user.User;
import uncg.marketplace.entity.user.UserRole;

public class Mapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertRegisterDtoToUser(RegisterDTO registerDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user;
        user = modelMapper.map(registerDTO, User.class);
        user.setRole(UserRole.USER);
        return user;
    }






}
