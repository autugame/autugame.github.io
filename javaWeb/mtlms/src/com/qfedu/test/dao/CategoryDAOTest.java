package com.qfedu.test.dao;

import com.qfedu.mtlms.dao.CategoryDAO;
import com.qfedu.mtlms.dto.Category;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryDAOTest {
    private static final CategoryDAO CATEGORY_DAO = new CategoryDAO();

    @Test
    public void selectCategories() {
        List<Category> categories = CATEGORY_DAO.selectCategories();
        System.out.println();
    }

    @Test
    public void deleteCategoryById() {
        CATEGORY_DAO.deleteCategoryById(12);
    }

    @Test
    public void selectCategoryById() {
        Category category = CATEGORY_DAO.selectCategoryById(12);
        System.out.println(category);
    }

    @Test
    public void updateCategory() {
        Category category = new Category(12, "摩托车", "bbb.png", "1");
        CATEGORY_DAO.updateCategory(category);
    }

    @Test
    public void insertCategory() {
        Category category = new Category(0, "摩托车", "aaa.png", "1");
        int i = CATEGORY_DAO.insertCategory(category);
        System.out.println(i);
    }
}