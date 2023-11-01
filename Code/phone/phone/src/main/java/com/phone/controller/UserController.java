package com.phone.controller;

import com.phone.payload.ResponseData;
import com.phone.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/list")
    public ResponseEntity<?> getAllUser(){

        ResponseData responseData = new ResponseData();

        responseData.setData(userServiceImp.getAllUser());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
