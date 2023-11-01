package com.phone.service.imp;

import com.phone.dto.CategoryDTO;
import com.phone.entity.Category;

import java.util.List;

public interface CategoryServiceImp {
    boolean insertCategory(String name_cate, int status);
    List<CategoryDTO> getCategoryHomePage();
//    Category updateCategory(int id, Category category);
//    boolean deleteCategory(int id);
    List<CategoryDTO> getAllCategory();
}
