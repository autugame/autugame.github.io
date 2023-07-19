package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/MenuListServlet")
public class MenuListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Query the level-1 and level-2 menus.
        MenuService menuService = new MenuService();
        Map<String, List> menus = menuService.listMenus();
        //2.Pass the level-1 and level-2 menus.
        req.setAttribute("menu1List", menus.get("menu1List"));
        req.setAttribute("menu2List", menus.get("menu2List"));
        req.getRequestDispatcher("admin_menu_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
