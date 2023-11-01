package com.phone.service.imp;

import com.phone.dto.UserDTO;
import com.phone.payload.request.SignupRequest;

import java.util.List;

public interface LoginServiceImp {
    List<UserDTO> getAllUser();
    boolean checkLogin(String username, String password);
    boolean addUser(SignupRequest signupRequest);
}
