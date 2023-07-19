package com.qfedu.mtlms.service;

import com.qfedu.mtlms.dao.BrandDAO;
import com.qfedu.mtlms.dao.CategoryDAO;
import com.qfedu.mtlms.dto.Brand;
import com.qfedu.mtlms.dto.Category;

import java.util.List;

/**
 * Classified information management business procession.
 */
public class CategoryService {
    private static final CategoryDAO CATEGORY_DAO = new CategoryDAO();
    private static final BrandDAO BRAND_DAO = new BrandDAO();
    /**
     * Query category list.
     * @return
     */
    public List<Category> listCategories(){
        return CATEGORY_DAO.selectCategories();
    }

    /**
     * Delete category information.
     * @param categoryId
     * @return
     */
    public boolean deleteCategoryById(int categoryId){
        //1.Query the brand information list by category id.
        List<Brand> brandList = BRAND_DAO.selectBrandsByCategoryId(categoryId);
        if (brandList.size()>0){
            return false;
        } else {
            int i = CATEGORY_DAO.deleteCategoryById(categoryId);
            return i > 0;
        }
    }

    /**
     * Query a class based on the class id.
     * @param categoryId
     * @return
     */
    public Category getCategoryById(int categoryId){
        return CATEGORY_DAO.selectCategoryById(categoryId);
    }

    /**
     * Change information.
     * @param category
     * @return
     */
    public boolean updateCategory(Category category){
        int i = CATEGORY_DAO.updateCategory(category);
        return i > 0;
    }

    /**
     * Save information.
     * @param category
     * @return
     */
    public boolean saveCategory(Category category){
        int i = CATEGORY_DAO.insertCategory(category);
        return i > 0;
    }
}
