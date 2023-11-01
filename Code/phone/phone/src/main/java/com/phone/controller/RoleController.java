package com.phone.controller;

import com.phone.service.imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleServiceImp roleServiceImp;

    @GetMapping("/list")
    public ResponseEntity<?> getAllRole(){

        return new ResponseEntity<>(roleServiceImp.getAllRole(), HttpStatus.OK);
    }
}
