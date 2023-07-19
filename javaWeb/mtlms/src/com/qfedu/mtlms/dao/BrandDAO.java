package com.qfedu.mtlms.dao;

import com.qfedu.mtlms.dto.Brand;
import com.qfedu.mtlms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Brand information database operation.
 */
public class BrandDAO {
    private static final QueryRunner QUERY_RUNNER = new QueryRunner(DruidUtils.getDataSource());
    /**
     * Query the list of brands by category id.
     * @param categoryId
     * @return
     */
    public List<Brand> selectBrandsByCategoryId(int categoryId){
        List<Brand> brandList = new ArrayList<>();
        try {
            String sql = "select b.brand_id brandId,b.brand_name brandName,b.brand_logo brandLogo,b.brand_desc brandDesc,b.create_time createTime,b.brand_status brandStatus from tb_category_brand cb inner join tb_brand b on cb.fk_brand_id = b.brand_id where cb.fk_category_id=?";
            brandList = QUERY_RUNNER.query(sql, new BeanListHandler<>(Brand.class), categoryId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brandList;
    }

    /**
     * Save brand information.
     * @param brand
     * @return Generated brand id.
     */
    public int insertBrand(Brand brand){
        int i = 0;
        try {
            String sql = "insert into tb_brand(brand_name,brand_logo,brand_desc,create_time,brand_status) values(?,?,?,?,?)";
            BigInteger object = QUERY_RUNNER.insert(sql, new ScalarHandler<>(), brand.getBrandName(), brand.getBrandLogo(), brand.getBrandDesc(), brand.getCreateTime(), brand.getBrandStatus());
            i = object.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Save the association between categories and brands.
     * @param cid
     * @param bid
     * @return
     */
    public int insertCategoryAndBrand(int cid, int bid){
        int i = 0;
        try {
            String sql = "insert into tb_category_brand(fk_category_id, fk_brand_id) values(?,?)";
            i = QUERY_RUNNER.update(sql, cid, bid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Query brand information by id.
     * @param brandId
     * @return
     */
    public Brand selectBrandByBrandId(int brandId){
        Brand brand = null;
        try {
            String sql = "select brand_id brandId,brand_name brandName,brand_logo brandLogo,brand_desc brandDesc,create_time createTime,brand_status brandStatus from tb_brand where brand_id=?";
            brand = QUERY_RUNNER.query(sql, new BeanHandler<>(Brand.class), brandId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brand;
    }

    public int updateBrand(Brand brand){
        int i = 0;
        try {
            String sql = "update tb_brand set brand_name=?,brand_logo=?,brand_desc=?,brand_status=? where brand_id=?";
            Object[] params = {brand.getBrandName(), brand.getBrandLogo(), brand.getBrandDesc(), brand.getBrandStatus(), brand.getBrandId()};
            i = QUERY_RUNNER.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
    public int deleteBrand(int brandId){
        int i = 0;
        try {
            String sql = "delete from tb_brand where brand_id=?";
            i = QUERY_RUNNER.update(sql, brandId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Delete association between brand and category.
     * @param brandId
     * @return
     */
    public int deleteCategoryAndBrand(int brandId){
        int i = 0;
        try {
            String sql = "delete from tb_category_brand where fk_brand_id=?";
            i = QUERY_RUNNER.update(sql, brandId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
