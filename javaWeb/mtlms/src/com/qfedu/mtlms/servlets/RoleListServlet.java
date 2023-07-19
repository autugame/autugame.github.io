package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Role;
import com.qfedu.mtlms.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RoleListServlet")
public class RoleListServlet extends HttpServlet {
    private static final RoleService ROLE_SERVICE = new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Query all roles.
        List<Role> roleList = ROLE_SERVICE.getRoles();
        //2.Send role list.
        req.setAttribute("roleList", roleList);
        req.getRequestDispatcher("admin_role_list.jsp").forward(req, resp);
    }
}
