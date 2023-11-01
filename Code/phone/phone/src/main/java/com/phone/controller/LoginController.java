package com.phone.controller;

import com.phone.payload.ResponseData;
import com.phone.payload.request.SignupRequest;
import com.phone.service.LoginService;
import com.phone.service.imp.LoginServiceImp;
import com.phone.utils.JwtUtilsHelper;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;

    @PostMapping("/singin")
    public ResponseEntity<?> singin(@RequestParam String username, @RequestParam String password){
        ResponseData responseData = new ResponseData();

        if (loginServiceImp.checkLogin(username,password)){
            String token = jwtUtilsHelper.generateToken(username);
            responseData.setData(token);

        }else {
            responseData.setData("");
            responseData.setSuccess(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest){
        ResponseData responseData = new ResponseData();

        responseData.setData(loginServiceImp.addUser(signupRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser(){
        ResponseData responseData = new ResponseData();
       responseData.setData(loginServiceImp.getAllUser());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
