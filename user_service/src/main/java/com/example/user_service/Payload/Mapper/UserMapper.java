package com.example.user_service.Payload.Mapper;

import org.springframework.stereotype.Service;

import com.example.user_service.Enitity.User;
import com.example.user_service.Payload.Request.UserRequest;
import com.example.user_service.Payload.Response.UserResponse;

@Service
public class UserMapper {

    public User toUser(UserRequest userRequest){

        return User.builder()
        .username(userRequest.username())
        .email(userRequest.email())
        .password(userRequest.password())
        .build();
    }
    public UserResponse toUserResponse(User user)
    {
        return new UserResponse( 
            user.getId().toString(),
            user.getUsername(),
            user.getEmail(),
            user.getActive(),
            user.getRole()            
        );
    }
    
}
