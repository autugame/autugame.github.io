package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Brand;
import com.qfedu.mtlms.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Query brand information.
 */
@WebServlet("/BrandQueryServlet")
public class BrandQueryServlet extends HttpServlet {
    private static final BrandService BRAND_SERVICE = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receive brand id.
        int brandId = Integer.parseInt(req.getParameter("brandId"));
        //Query the brand information based on the id.
        Brand brand = BRAND_SERVICE.getBrandById(brandId);
        //Pass to the modify page.
        req.setAttribute("brand", brand);
        req.getRequestDispatcher("brand_modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
