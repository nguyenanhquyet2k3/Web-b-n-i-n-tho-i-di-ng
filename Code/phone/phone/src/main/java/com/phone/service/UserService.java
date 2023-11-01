package com.phone.service;

import com.phone.dto.RoleDTO;
import com.phone.dto.UserDTO;
import com.phone.entity.Role;
import com.phone.entity.User;
import com.phone.repository.UserRepository;
import com.phone.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserDTO> getAllUser() {

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
}
