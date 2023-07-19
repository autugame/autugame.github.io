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

/**
 * Modified classification.
 */
@MultipartConfig
@WebServlet("/CategoryUpdateServlet")
public class CategoryUpdateServlet extends HttpServlet {
    private static final CategoryService CATEGORY_SERVICE = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //Receiving sort information.
        String id = req.getParameter("categoryId");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String categoryName = req.getParameter("categoryName");
        String categoryIcon = req.getParameter("oldCategoryIcon");
        //Receive the modified images information.
        Part part = req.getPart("categoryIcon");
        if (part.getSize() > 0){
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
            categoryIcon = "categoryImages/" + iconName;
        }
        //Modify to database.
        Category category = new Category(categoryId, categoryName, categoryIcon, "1");
        boolean b = CATEGORY_SERVICE.updateCategory(category);
        if (b){
            req.setAttribute("type", "success");
            req.setAttribute("tips", "修改成功！");
            req.getRequestDispatcher("CategoryListServlet").forward(req, resp);
        } else {
            req.setAttribute("type", "error");
            req.setAttribute("tips", "修改失败！");
            req.getRequestDispatcher("CategoryListServlet").forward(req, resp);
        }
    }
}
