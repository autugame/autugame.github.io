package com.qfedu.mtlms.dao;

import com.qfedu.mtlms.dto.Category;
import com.qfedu.mtlms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement classified information database operation.
 */
public class CategoryDAO {
    private static final QueryRunner QUERY_RUNNER = new QueryRunner(DruidUtils.getDataSource());
    public List<Category> selectCategories(){
        List<Category> list = new ArrayList<>();
        try {
            String sql = "select category_id categoryId, category_name categoryName, category_icon categoryIcon, category_status categoryStatus from tb_category";
            list = QUERY_RUNNER.query(sql, new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int deleteCategoryById(int categoryId){
        int i = 0;
        try {
            String sql = "delete from tb_category where category_id=?";
            i = QUERY_RUNNER.update(sql, categoryId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public Category selectCategoryById(int categoryId){
        Category category = null;
        try {
            String sql = "select category_id categoryId, category_name categoryName, category_icon categoryIcon, category_status categoryStatus from tb_category where category_id=?";
            category = QUERY_RUNNER.query(sql, new BeanHandler<>(Category.class), categoryId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }

    public int updateCategory(Category category){
        int i = 0;
        try {
            String sql = "update tb_category set category_name=?, category_icon=? where category_id=?";
            i = QUERY_RUNNER.update(sql, category.getCategoryName(), category.getCategoryIcon(), category.getCategoryId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public int insertCategory(Category category){
        int i = 0;
        try {
            String sql = "insert into tb_category(category_name, category_icon, category_status) value(?,?,1)";
            i = QUERY_RUNNER.update(sql, category.getCategoryName(), category.getCategoryIcon());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
