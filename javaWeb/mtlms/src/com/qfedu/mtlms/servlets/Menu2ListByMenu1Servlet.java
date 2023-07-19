package com.qfedu.mtlms.servlets;

import com.google.gson.Gson;
import com.qfedu.mtlms.dto.Menu2;
import com.qfedu.mtlms.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Query the level 2 menu based on the level 1 menu
 */
@WebServlet("/Menu2ListByMenu1Servlet")
public class Menu2ListByMenu1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Receive a level 1 menu number.
        String parentCode = req.getParameter("parentCode");
        //2.Query the level 2 based on the level 1 menu number.
        MenuService menuService = new MenuService();
        List<Menu2> menu2List = menuService.listMenu2ByMenu1Code(parentCode);
        //3.Response page 'menu2List' json format.
        //3.1 Convert the connection to json format.
        Gson gson = new Gson();
        String json = gson.toJson(menu2List);
        //3.2 Response ajax request.
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
