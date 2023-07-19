package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Menu1;
import com.qfedu.mtlms.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Query menu list.
 */
@WebServlet("/MenuListAllServlet")
public class MenuListAllServlet extends HttpServlet {
    private static final MenuService MENU_SERVICE = new MenuService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Example Query all menus in the system.
        List<Menu1> menu1List = MENU_SERVICE.listAllMenus();
        //Send menu set.
        req.setAttribute("menu1List", menu1List);
        req.getRequestDispatcher("admin_role_add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
