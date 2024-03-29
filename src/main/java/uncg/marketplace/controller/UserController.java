package uncg.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uncg.marketplace.dto.RegisterDTO;
import uncg.marketplace.dto.UserDTO;
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


    /* UserDTO optional = service.registerUser(registerDTO);
    User newUser;
    if(optional.isPresent()){
        newUser = service.convertEntityToDto(optional.get());
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    else{
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
     */

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegisterDTO registerDTO){
        UserDTO created = service.registerUser(registerDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);

    }

    /**
     * Returns a list of users
     * @return List<User>
     */
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    /**
     * This is meant for ADMIN to add more admins, will update later on.
     * @param user
     * @return user
     */
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        service.addUser(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    /**
     * Enter userId and returns all the information in DB pertaining to that userId.
     * @param id
     * @return user
     */
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

    /**
     * Deletes user by userId.
     * @param id
     * @return HttpStatus.OK
     */
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id){
        service.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
