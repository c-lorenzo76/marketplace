package uncg.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uncg.marketplace.dto.RegisterDTO;
import uncg.marketplace.dto.UserDTO;
import uncg.marketplace.entity.user.User;
import uncg.marketplace.service.user.UserService;

import java.util.Optional;


@RestController
@RequestMapping("/marketplace")
public class MarketplaceController {

    @Autowired
    private UserService userService;

    /*
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegisterDTO registrationDTO){
        Optional<UserDTO> optional = userService.registerUser(registrationDTO);
        if(optional.isPresent()){
            UserDTO userDTO = optional.get();
            return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    */






}
