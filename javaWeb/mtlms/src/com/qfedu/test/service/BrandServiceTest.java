package com.qfedu.test.service;

import com.qfedu.mtlms.dto.Brand;
import com.qfedu.mtlms.service.BrandService;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class BrandServiceTest {
    private static final BrandService BRAND_SERVICE = new BrandService();
    @Test
    public void addBrand() {
        Brand brand = new Brand(0, "动力火车", "upload/aaa.png", "haha", new Date(), 1);
        boolean b = BRAND_SERVICE.addBrand(brand, 16);
        System.out.println(b);
    }

    @Test
    public void getBrandById(){
        Brand brandById = BRAND_SERVICE.getBrandById(1);
        System.out.println(brandById);
    }
    @Test
    public void updateBrand(){
        Brand brand = new Brand(23, "超人牌自信车", "upload/c05ee8fc9bbb40d5a785ccb0eb8725b4.jpg", "红牛赞助,超级无敌", new Date(), 1);
        Boolean b = BRAND_SERVICE.updateBrand(brand);
        System.out.println(b);
    }
    @Test
    public void deleteBrandById(){
        BRAND_SERVICE.deleteBrandById(24);
    }
}