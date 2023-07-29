package com.qfedu.mtlms.servlets;

import com.google.gson.Gson;
import com.qfedu.mtlms.dto.Brand;
import com.qfedu.mtlms.service.BrandService;
import com.qfedu.mtlms.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Query brands information
 */
@WebServlet("/BrandListForAjaxServlet")
public class BrandListForAjaxServlet extends HttpServlet {
    private static final BrandService BRAND_SERVICE = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receive the category id.
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        List<Brand> brandList = BRAND_SERVICE.listBrandsByCategoryId(categoryId);

        //Convert to JSON.
        ResultVO resultVO = brandList!=null?new ResultVO(1, "success", brandList):new ResultVO(0, "fail");
        String jsonStr = new Gson().toJson(resultVO);
        //Response to ajax requests.
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }
}
