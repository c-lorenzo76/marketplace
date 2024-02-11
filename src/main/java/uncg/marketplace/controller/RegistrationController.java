package uncg.marketplace.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uncg.marketplace.dto.RegistrationDTO;
import uncg.marketplace.entity.user.User;
import uncg.marketplace.service.user.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;

    /*
    @PostMapping("")
    public ResponseEntity<User> register(@RequestBody RegistrationDTO registrationDTO){
        Optional<User> optional = userService.signUpUser(registrationDTO);
        User user;
        if(optional.isPresent()){
            user = optional.get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    */

    /*
    @PostMapping("/add")
    public ResponseEntity<User> register(@RequestBody RegistrationDTO request){
        return registrationService.register(request);
    }
    */



}
