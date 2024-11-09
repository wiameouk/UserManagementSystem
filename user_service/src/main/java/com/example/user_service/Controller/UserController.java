package com.example.user_service.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.user_service.Payload.Request.ChangePasswordRequest;
import com.example.user_service.Payload.Request.UserRequest;
import com.example.user_service.Payload.Response.UserResponse;
import com.example.user_service.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveNewUser(@RequestBody @Valid UserRequest userRequest)
    {
        userService.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();

        
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
        
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable("id") String userId)
    {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") String userId , @RequestBody UserRequest userRequest)
    {
        userService.updateUser(userId, userRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String userId)
    {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PutMapping("/{id}/password")
    public ResponseEntity<Void> changePassword(@PathVariable("id") String userId,@RequestBody @Valid ChangePasswordRequest changePasswordRequest) 
    {
        userService.changePassword(userId, changePasswordRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }    
    
}
