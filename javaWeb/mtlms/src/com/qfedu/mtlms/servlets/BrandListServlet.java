package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Brand;
import com.qfedu.mtlms.dto.Category;
import com.qfedu.mtlms.service.BrandService;
import com.qfedu.mtlms.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BrandListServlet")
public class BrandListServlet extends HttpServlet {
    private static final BrandService BRAND_SERVICE = new BrandService();
    private static final CategoryService CATEGORY_SERVICE = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receive the category id.
        String categoryId = req.getParameter("categoryId");

        //Query a list of all categories.
        List<Category> categoryList = CATEGORY_SERVICE.listCategories();

        //Query the brand information of the current brand according to the category id.
        //if categoryId=null
        int cid = categoryId==null?categoryList.get(0).getCategoryId():Integer.parseInt(categoryId);
        List<Brand> brandList = BRAND_SERVICE.listBrandsByCategoryId(cid);
        //Transfer data.
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("cid", cid);
        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher("brand_list.jsp").forward(req, resp);
    }
}
