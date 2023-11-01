package com.phone.controller;

import com.phone.entity.Category;
import com.phone.payload.ResponseData;
import com.phone.service.CategoryService;
import com.phone.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @PostMapping ("/add")
    public ResponseEntity<?> createCategory(@RequestParam String name_cate, @RequestParam int status){

        ResponseData responseData = new ResponseData();
        boolean isSuccess = categoryServiceImp.insertCategory(name_cate,status);
        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getHomeCategory(){

        ResponseData responseData = new ResponseData();

        responseData.setData(categoryServiceImp.getCategoryHomePage());

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }


    @GetMapping("/list")
    public ResponseEntity<?> getAllCategory(){

        ResponseData responseData = new ResponseData();

        responseData.setData(categoryServiceImp.getAllCategory());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
