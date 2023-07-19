package com.qfedu.mtlms.servlets;

import com.google.gson.Gson;
import com.qfedu.mtlms.dto.Manager;
import com.qfedu.mtlms.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Query administrator
 */
@WebServlet("/ManagerQueryServlet")
public class ManagerQueryServlet extends HttpServlet {
    private static final ManagerService MANAGER_SERVICE = new ManagerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get administrator id.
        String managerId = req.getParameter("managerId");

        //Invoke manager service to query the original administrator id.
        Manager manager = MANAGER_SERVICE.getManagerById(managerId);
        String jsonStr = new Gson().toJson(manager);

        //Responding to ajax request.
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(jsonStr);
        out.flush();
        out.close();
    }
}
