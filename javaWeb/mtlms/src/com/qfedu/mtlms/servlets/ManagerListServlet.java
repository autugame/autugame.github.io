package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Manager;
import com.qfedu.mtlms.dto.Role;
import com.qfedu.mtlms.service.ManagerService;
import com.qfedu.mtlms.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Administrator list function.
 */
@WebServlet("/ManagerListServlet")
public class ManagerListServlet extends HttpServlet {
    private static final ManagerService MANAGER_SERVICE = new ManagerService();
    private static final RoleService ROLE_SERVICE = new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Example Query the administrator list.
        List<Manager> managers = MANAGER_SERVICE.listManagers();
        //Example Query the role list.
        List<Role> roles = ROLE_SERVICE.getRoles();
        //Send data.
        req.setAttribute("managerList", managers);
        req.setAttribute("roleList", roles);
        req.getRequestDispatcher("admin_manager_list.jsp").forward(req, resp);
    }
}
