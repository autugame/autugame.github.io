package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Category;
import com.qfedu.mtlms.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Query classification information by ic.
 */
@WebServlet("/CategoryQueryServlet")
public class CategoryQueryServlet extends HttpServlet {
    private static final CategoryService CATEGORY_SERVICE = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receive the category id passed after clicking the modification.
        int categoryId = Integer.parseInt(req.getParameter("cid"));
        //Query classification information by id.
        Category category = CATEGORY_SERVICE.getCategoryById(categoryId);
        //Pass classified information.
        req.setAttribute("category", category);
        req.getRequestDispatcher("category_modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
