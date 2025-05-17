package service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
                Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst().orElse(null);
        if (category == null)
            return "Category not found";

        categories.remove(category);
        return "Category with categoryId: " + categoryId + " deleted successfully !!";
    }
}
