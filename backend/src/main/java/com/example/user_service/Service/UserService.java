package com.example.user_service.Service;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user_service.Enitity.Role;
import com.example.user_service.Enitity.User;
import com.example.user_service.EntityRepository.RoleRepository;
import com.example.user_service.EntityRepository.UserRepository;
import com.example.user_service.Exception.InvalidDataException;
import com.example.user_service.Exception.UserNotFoundException;
import com.example.user_service.IService.IUserService;
import com.example.user_service.Payload.Mapper.UserMapper;
import com.example.user_service.Payload.Request.ChangePasswordRequest;
import com.example.user_service.Payload.Request.UserRequest;
import com.example.user_service.Payload.Response.UserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public void saveUser(UserRequest userRequest) {
        
        if(userRepository.existsByUsername(userRequest.username()) || userRepository.existsByEmail(userRequest.email())){
            throw new InvalidDataException("Cannot Create user because Already exist");
        }
        User user =userMapper.toUser(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        if(userRequest.roleId() !=null){
            Set<Role> roles = userRequest.roleId().stream()
                .map(roleId -> roleRepository.findById(UUID.fromString(roleId))
                .orElseThrow(() -> new InvalidDataException("Role not found with ID: " + roleId)))
                .collect(Collectors.toSet());
            user.setRoles(roles);
        }
        userRepository.save(user);    
    }

    @Override
    public UserResponse getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId))
            .map(userMapper::toUserResponse)
            .orElseThrow(()-> new UserNotFoundException("User Service :: User not Found" +userId));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(userMapper::toUserResponse)
            .collect(Collectors.toList());
    }
   
    @Override
    @Transactional
    public void deleteUser(String userId) {
        if(userRepository.existsById(UUID.fromString(userId))){
            userRepository.deleteById(UUID.fromString(userId));
        }else{
            throw new UserNotFoundException("User Service :: User not Found" +userId);
        }      
    }   
    @Override
    @Transactional
    public void updateUser(String userId, UserRequest userRequest) {
        User user = userRepository.findById(UUID.fromString(userId))
            .orElseThrow(()-> new UserNotFoundException("User Service :: not found with id " +userId) );
        if(!user.getEmail().equals(userRequest.email())){
            if(!userRepository.existsByEmail(userRequest.email())){
                user.setEmail(userRequest.email());
            }else{
                throw new InvalidDataException("User Service :: cannot create user already exist email");
            }
        }
        if(!user.getUsername().equals(userRequest.username())){
            if(!userRepository.existsByUsername(userRequest.username())){
                user.setUsername(userRequest.username());
            }else{
                throw new InvalidDataException("user service :: cannot create user already exist username");
            }
        }
        if(userRequest.active() != null)
        {
            user.setActive(userRequest.active());
        }
        if(userRequest.roleId() !=null){
            Set<Role> roles = userRequest.roleId().stream()
                .map(roleId -> roleRepository.findById(UUID.fromString(roleId))
                .orElseThrow(() -> new InvalidDataException("Role not found with ID: " + roleId)))
                .collect(Collectors.toSet());
            user.setRoles(roles);
        }
        userRepository.save(user);   
    }
    @Override
    @Transactional
    public void changePassword(String userId, ChangePasswordRequest psswrequest) {
        User user=userRepository.findById(UUID.fromString(userId))
            .orElseThrow(()-> new UserNotFoundException("Utilisateur non trouve"));
        if (!passwordEncoder.matches(psswrequest.oldPassword(), user.getPassword())) {
            throw new InvalidDataException ("L'ancien mot de passe est incorrect.");
        }
        user.setPassword(passwordEncoder.encode(psswrequest.changePassword()));
        userRepository.save(user);
    } 
}
