package com.qfedu.ioc.servlet;

import com.qfedu.ioc.service.ProductService;

public class TestServlet {
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void doGet(){
        doPost();
    }
    public void doPost(){
        productService.listProducts();
    }
}
