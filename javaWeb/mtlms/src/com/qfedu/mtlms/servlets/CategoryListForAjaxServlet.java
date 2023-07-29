package com.qfedu.mtlms.servlets;

import com.google.gson.Gson;
import com.qfedu.mtlms.dto.Category;
import com.qfedu.mtlms.service.CategoryService;
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
 * Query classification information in response to ajax requests.
 */
@WebServlet("/CategoryListForAjaxServlet")
public class CategoryListForAjaxServlet extends HttpServlet {
    private static final CategoryService CATEGORY_SERVICE = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Category listings.
        List<Category> categoryList = CATEGORY_SERVICE.listCategories();
        //Convert to JSON.
        ResultVO resultVO = categoryList!=null?new ResultVO(1, "success", categoryList):new ResultVO(0, "fail");
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
