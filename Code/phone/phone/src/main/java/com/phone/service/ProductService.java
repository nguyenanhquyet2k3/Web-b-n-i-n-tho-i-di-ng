package com.phone.service;

import com.phone.dto.CategoryDTO;
import com.phone.dto.ProductDTO;
import com.phone.entity.Category;
import com.phone.entity.Product;
import com.phone.repository.ProductRepository;
import com.phone.service.imp.FileServiceImp;
import com.phone.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean createProduct(MultipartFile file, int category_id, String name_product, String information, double price, String created_at, String update_at, int status) {
            boolean isInsertSuccess = false;

            try {
                boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
                if (isSaveFileSuccess) {
                    Category category = new Category();
                    category.setId(category_id);

                    Product product = new Product();
                    product.setCategory(category);
                    product.setNameProduct(name_product);
                    product.setImage(file.getOriginalFilename());
                    product.setInformation(information);
                    product.setPrice(price);

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date createdat = simpleDateFormat.parse(created_at);
                    product.setCreatedAt(createdat);
                    Date updateat = simpleDateFormat.parse(update_at);
                    product.setUpdateAt(updateat);
                    product.setStatus(status);

                    productRepository.save(product);
                    isInsertSuccess = true;
                }

            } catch (Exception e){
                System.out.println("Error insert product " +e.getMessage());
            }



        return isInsertSuccess;
    }

    @Override
    public List<ProductDTO> getHomeProduct() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0,6);
        Page<Product> listData = productRepository.findAll(pageRequest);

        for (Product data : listData) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(data.getId());
            productDTO.setImage(data.getImage());
            productDTO.setNameProduct(data.getNameProduct());
            productDTO.setPrice(data.getPrice());

            productDTOS.add(productDTO);
        }
        
        return productDTOS;
    }


    @Override
    public ProductDTO getDetailProduct(int id) {

        Optional<Product> product = productRepository.findById(id);
        ProductDTO productDTO = new ProductDTO();
        if (product.isPresent()){
            Product data = product.get();
            productDTO.setImage(data.getImage());
            productDTO.setNameProduct(data.getNameProduct());
            productDTO.setPrice(data.getPrice());
            productDTO.setInformation(data.getInformation());
        }

        return productDTO;
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductDTO> listProduct = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        for (Product data : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(data.getId());
            productDTO.setNameProduct(data.getNameProduct());
            productDTO.setImage(data.getImage());
            productDTO.setInformation(data.getInformation());
            productDTO.setPrice(data.getPrice());
            productDTO.setCreatedAt(data.getCreatedAt());
            productDTO.setUpdateAt(data.getUpdateAt());
            productDTO.setStatus(data.getStatus());

            listProduct.add(productDTO);

        }
        return listProduct;
    }
}
