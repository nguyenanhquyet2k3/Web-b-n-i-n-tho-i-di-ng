package com.phone.service.imp;

import com.phone.dto.ProductDTO;
import com.phone.entity.Category;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface ProductServiceImp {
    boolean createProduct(  MultipartFile file,
                            int category_id,
                            String name_product,
                            String information,
                            double price,
                            String created_at,
                            String update_at,
                            int status);
    List<ProductDTO> getHomeProduct();
    List<ProductDTO> getAllProduct();
    ProductDTO getDetailProduct(int id);
}
