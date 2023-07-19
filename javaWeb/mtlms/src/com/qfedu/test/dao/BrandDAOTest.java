package com.qfedu.test.dao;

import com.qfedu.mtlms.dao.BrandDAO;
import com.qfedu.mtlms.dto.Brand;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BrandDAOTest {
    private static final BrandDAO BRAND_DAO = new BrandDAO();

    @Test
    public void selectBrandsByCategoryId() {
        List<Brand> brands = BRAND_DAO.selectBrandsByCategoryId(1);
        System.out.println();
    }
}