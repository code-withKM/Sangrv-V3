package service;

import java.util.List;

import model.Category;



public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    public String deleteCategory(Long categoryId);

    public Category updateCategory(Category category, Long categoryId);


}