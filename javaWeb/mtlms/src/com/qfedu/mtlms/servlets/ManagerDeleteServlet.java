package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ManagerDeleteServlet")
public class ManagerDeleteServlet extends HttpServlet {
    private static final ManagerService MANAGER_SERVICE = new ManagerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receiving administrator id.
        String mgrId = req.getParameter("mgrId");
        //Execute delete.
        boolean b = MANAGER_SERVICE.deleteManager(mgrId);
        //Response results.
        String jsonStr = b?"{\"code\":1, \"msg\":\"success\"}":"{\"code\":0, \"msg\":\"fail\"}";
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(jsonStr);
        out.flush();
        out.close();
    }
}
