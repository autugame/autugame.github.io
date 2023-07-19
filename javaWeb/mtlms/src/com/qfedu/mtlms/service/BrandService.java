package com.qfedu.mtlms.service;

import com.qfedu.mtlms.dao.BrandDAO;
import com.qfedu.mtlms.dao.GoodsDAO;
import com.qfedu.mtlms.dto.Brand;
import com.qfedu.mtlms.dto.Goods;

import java.util.List;

/**
 * complete brand business procession.
 */
public class BrandService {
    private static final BrandDAO BRAND_DAO = new BrandDAO();
    private static final GoodsDAO GOODS_DAO = new GoodsDAO();
    /**
     * Query the brand information in the current category based on the category id.
     * @return
     */
    public List<Brand> listBrandsByCategoryId(int categoryId){
        return BRAND_DAO.selectBrandsByCategoryId(categoryId);
    }

    /**
     * Save brand information.
     * @param brand
     * @param categoryId
     * @return
     */
    public boolean addBrand(Brand brand, int categoryId){
        //Gets the generated brand id.
        int brandId = BRAND_DAO.insertBrand(brand);
        //Preserve relationship.
        int i = BRAND_DAO.insertCategoryAndBrand(categoryId, brandId);
        return i>0;
    }

    /**
     * Query brand information by id.
     * @param brandId
     * @return
     */
    public Brand getBrandById(int brandId){
        return BRAND_DAO.selectBrandByBrandId(brandId);
    }

    /**
     * Modify brand information.
     * @param brand
     * @return
     */
    public Boolean updateBrand(Brand brand){
        int i = BRAND_DAO.updateBrand(brand);
        return i > 0;
    }

    /**
     * Delete brand information based on brand id.
     * @param brandId
     * @return
     */
    public boolean deleteBrandById(int brandId){
        //Query product information based on brand id.
        List<Goods> goods = GOODS_DAO.selectGoods(brandId);
        //If the goods information is empty.
        if (goods.size() == 0){
            //Delete brand and category associations.
            int j = BRAND_DAO.deleteCategoryAndBrand(brandId);
            //Delete brand information.
            int i = BRAND_DAO.deleteBrand(brandId);
            return i > 0 && j > 0;
        } else {
            return false;
        }
    }
}
