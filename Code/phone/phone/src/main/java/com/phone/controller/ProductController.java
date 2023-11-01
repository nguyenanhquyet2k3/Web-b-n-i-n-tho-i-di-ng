package com.phone.controller;

import com.phone.entity.Category;
import com.phone.payload.ResponseData;
import com.phone.service.imp.FileServiceImp;
import com.phone.service.imp.ProductServiceImp;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    ProductServiceImp productServiceImp;

    @PostMapping()
    public ResponseEntity<?> createProduct(
            @RequestParam MultipartFile file,
            @RequestParam int category_id,
            @RequestParam String name_product,
            @RequestParam String information,
            @RequestParam double price,
            @RequestParam String created_at,
            @RequestParam String update_at,
            @RequestParam int status){


        ResponseData responseData = new ResponseData();
        boolean isSuccess = productServiceImp.createProduct(file,category_id,name_product,information, price, created_at, update_at,status);
        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<?> getHomeProduct(){

        ResponseData responseData = new ResponseData();

        responseData.setData(productServiceImp.getHomeProduct());

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }


    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getFileProduct(@PathVariable String filename){
        Resource resource = fileServiceImp.loadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=/" + resource.getFilename() + "/").body(resource);

    }

    @GetMapping("/detail")
    public ResponseEntity<?> getDetailProduct(@RequestParam int id){

        ResponseData responseData = new ResponseData();
        responseData.setData(productServiceImp.getDetailProduct(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllCategory(){

        ResponseData responseData = new ResponseData();

        responseData.setData(productServiceImp.getAllProduct());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
