package uncg.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uncg.marketplace.entity.user.User;
import uncg.marketplace.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> optional = service.getUserById(id);
        User user;
        if(optional.isPresent()){
            user = optional.get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id){
        service.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // TODO: Have to make this an admin only , since i want to only be able to add in register controller.
    // Will leave this for now
    @PostMapping("/add")
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        service.addUser(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }



}
