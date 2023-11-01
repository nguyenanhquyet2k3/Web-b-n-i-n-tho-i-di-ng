package com.phone.service;

import com.phone.dto.UserDTO;
import com.phone.entity.Role;
import com.phone.entity.User;
import com.phone.payload.request.SignupRequest;
import com.phone.repository.UserRepository;
import com.phone.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImp {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUser(){
        List<User> listUser = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : listUser){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setFullName(user.getFullName());
            userDTO.setUserName(user.getUserName());
            userDTO.setPassword(user.getPassword());
            userDTO.setPhone(user.getPhone());
            userDTO.setEmail(user.getEmail());

            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        User user = userRepository.findByUserName(username);

        return passwordEncoder.matches(password,user.getPassword());

    }

    @Override
    public boolean addUser(SignupRequest signupRequest) {

        Role role = new Role();
        role.setId(signupRequest.getRoleId());


        User user = new User();
        user.setFullName(signupRequest.getFullname());
        user.setUserName(signupRequest.getUsername());
        String enterpassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(enterpassword);
        user.setPhone(signupRequest.getPhone());
        user.setEmail(signupRequest.getEmail());
        user.setRole(role);

        try {
            userRepository.save(user);
            return true;
        } catch (Exception e){
            return false;
        }

    }


}
