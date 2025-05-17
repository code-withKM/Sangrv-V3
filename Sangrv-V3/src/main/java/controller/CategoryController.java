package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Category;
import service.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private List<Category> categories= new ArrayList<>();

    @GetMapping("/api/categories")
    public List<Category> getAllCategories(){
        return categories;
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category added successfully";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        String status = categoryService.deleteCategory(categoryId);
        return status;
    }
}
