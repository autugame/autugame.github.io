package com.qfedu.mtlms.servlets;

import com.google.gson.Gson;
import com.qfedu.mtlms.service.BrandService;
import com.qfedu.mtlms.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Delete brand information.
 */
@WebServlet("/BrandDeleteServlet")
public class BrandDeleteServlet extends HttpServlet {
    private static final BrandService BRAND_SERVICE = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receive brand id.
        int brandId = Integer.parseInt(req.getParameter("brandId"));
        //Perform deletion.
        boolean b = BRAND_SERVICE.deleteBrandById(brandId);

        //Responding to ajax requests.
        ResultVO resultVO = b?new ResultVO(1, "success"):new ResultVO(0, "error");
        String jsonStr = new Gson().toJson(resultVO);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }
}
