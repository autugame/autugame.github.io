package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MenuStateChangeServlet")
public class MenuStateChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Receives menuCode and operations.
        String menuCode = req.getParameter("menuCode");
        String oper = req.getParameter("oper");
        //1.Enable or disable according to oper.
        MenuService menuService = new MenuService();
        boolean b = false;
        if ("stop".equals(oper)) {
            //disable
            b = menuService.disableMenu(menuCode);
        } else if ("start".equals(oper)) {
            //enable
            b = menuService.enableMenu(menuCode);
        }
        //3,Return the result of the operation.
        String json = b?"{\"code\":1, \"msg\":\"success\"}":"{\"code\":0, \"msg\":\"fail\"}";
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
