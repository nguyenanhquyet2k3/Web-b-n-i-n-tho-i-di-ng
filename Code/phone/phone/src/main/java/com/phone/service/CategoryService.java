package com.phone.service;

import com.phone.dto.CategoryDTO;
import com.phone.dto.ProductDTO;
import com.phone.entity.Category;
import com.phone.entity.Product;
import com.phone.repository.CategoryRepository;
import com.phone.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public boolean insertCategory(String name_cate, int status) {
        boolean isInsertSuccess = false;
        try {
            Category category = new Category();
            category.setNameCate(name_cate);
            category.setStatus(status);

            categoryRepository.save(category);

            isInsertSuccess = true;
        } catch (Exception e){
            System.out.println("Error insert category " +e.getMessage());

        }

        return isInsertSuccess;
    }

    @Override
    public List<CategoryDTO> getCategoryHomePage() {
        PageRequest pageRequest = PageRequest.of(0,6, Sort.by("id"));
        Page<Category> listCategory = categoryRepository.findAll(pageRequest);
        List<CategoryDTO> listcategoryDTOS = new ArrayList<>();

        for (Category data: listCategory){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setNameCate(data.getNameCate());

            List<ProductDTO> productDTOS = new ArrayList<>();
            for (Product dataProduct : data.getListProduct()){
                ProductDTO productDTO = new ProductDTO();
                productDTO.setNameProduct(dataProduct.getNameProduct());
                productDTO.setPrice(dataProduct.getPrice());
                productDTO.setImage(dataProduct.getImage());

                productDTOS.add(productDTO);
            }

            categoryDTO.setProducts(productDTOS);
            listcategoryDTOS.add(categoryDTO);
        }

        return listcategoryDTOS;
    }


    @Override
    public List<CategoryDTO> getAllCategory() {
        List<CategoryDTO> listcategoryDTOS = new ArrayList<>();
        List<Category> listCategory = categoryRepository.findAll();
        for (Category data : listCategory) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(data.getId());
            categoryDTO.setNameCate(data.getNameCate());
            categoryDTO.setStatus(data.getStatus());

            listcategoryDTOS.add(categoryDTO);

        }
        return listcategoryDTOS;
    }

}
