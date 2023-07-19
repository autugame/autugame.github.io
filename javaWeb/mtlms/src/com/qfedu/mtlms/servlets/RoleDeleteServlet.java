package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Deleting role information.
 */
@WebServlet("/RoleDeleteServlet")
public class RoleDeleteServlet extends HttpServlet {
    private static final RoleService ROLE_SERVICE = new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receiving role id.
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        //Invoke 'ROLE_SERVICE'.
        boolean b = ROLE_SERVICE.deleteRole(roleId);
        //Responding to ajax request.
        String str = b?"{\"code\":1,\"msg\":\"success\"}":"{\"code\":0,\"msg\":\"fail\"}";
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(str);
        out.flush();
        out.close();
    }
}
