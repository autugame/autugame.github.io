package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Brand;
import com.qfedu.mtlms.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Modify brand information.
 */
@WebServlet("/BrandUpdateServlet")
public class BrandUpdateServlet extends HttpServlet {
    private static final BrandService BRAND_SERVICE = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //Receive brand information.
        int brandId = Integer.parseInt(req.getParameter("brandId"));//hidden domain
        String brandName = req.getParameter("brandName");
        String brandLogoPath = req.getParameter("brandLogoPath");
        String brandDesc = req.getParameter("brandDesc");
        int brandStatus =  Integer.parseInt(req.getParameter("brandStatus"));
        Brand brand = new Brand(brandId, brandName, brandLogoPath, brandDesc, new Date(), brandStatus);

        //Execute modifications.
        Boolean b = BRAND_SERVICE.updateBrand(brand);
        if (b){
            req.setAttribute("type", "success");
            req.setAttribute("tips", "修改成功！");
            req.getRequestDispatcher("BrandListServlet").forward(req, resp);
        } else {
            req.setAttribute("type", "error");
            req.setAttribute("tips", "修改失败！");
            req.getRequestDispatcher("BrandListServlet").forward(req, resp);
        }
    }
}
