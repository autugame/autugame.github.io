package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Category;
import com.qfedu.mtlms.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@MultipartConfig
@WebServlet("/CategoryAddServlet")
public class CategoryAddServlet extends HttpServlet {
    private static final CategoryService CATEGORY_SERVICE = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receive category name.
        req.setCharacterEncoding("utf-8");
        String categoryName = req.getParameter("categoryName");
        //Receive category picture.
        Part part = req.getPart("categoryIcon");
        //Save picture information.
        //rename
        String header = part.getHeader("Content-Disposition");
        int i = header.lastIndexOf(".");
        int j = header.lastIndexOf("\"");
        String ext = header.substring(i, j);
        String iconName = UUID.randomUUID().toString().replace("-", "")+ext;
        //Get path.
        String dir = getServletContext().getRealPath("/categoryImages");
        //Save picture.
        part.write(dir+"/"+iconName);

        //Store categorical information to a database.
        Category category = new Category(0, categoryName, "categoryImages/" + iconName, "1");
        boolean b = CATEGORY_SERVICE.saveCategory(category);
        if (b){
            req.setAttribute("type", "success");
            req.setAttribute("tips", "保存成功！");
            req.getRequestDispatcher("CategoryListServlet").forward(req, resp);
        } else {
            req.setAttribute("type", "error");
            req.setAttribute("tips", "保存失败！");
            req.getRequestDispatcher("CategoryListServlet").forward(req, resp);
        }
    }
}
