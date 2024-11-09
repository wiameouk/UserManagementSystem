package com.example.user_service.IService;

import java.util.List;

import com.example.user_service.Payload.Request.ChangePasswordRequest;
import com.example.user_service.Payload.Request.UserRequest;
import com.example.user_service.Payload.Response.UserResponse;

public interface IUserService {
    
    void saveUser(UserRequest userRequest);
    UserResponse getUserById(String userId);
    List<UserResponse> getAllUsers();
    void updateUser(String userId , UserRequest userRequest);
    void deleteUser(String userId);
    void changePassword(String userId, ChangePasswordRequest psswrequest);

    

}
