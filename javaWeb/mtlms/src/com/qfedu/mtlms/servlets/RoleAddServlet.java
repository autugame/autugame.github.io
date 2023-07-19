package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Role;
import com.qfedu.mtlms.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Saving role information.
 */
@WebServlet("/RoleAddServlet")
public class RoleAddServlet extends HttpServlet {
    private static final RoleService ROLE_SERVICE = new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Receive the name and description of the role.
        req.setCharacterEncoding("UTF-8");
        String roleName = req.getParameter("roleName");
        String roleDesc = req.getParameter("roleDesc");
        //2.Gets the id of the menu permission.
        String[] menuIds = req.getParameterValues("menuId");
        //3.Saving role information.
        boolean b = ROLE_SERVICE.addRole(new Role(0, roleName, roleDesc), menuIds);
        //4.Jump to admin_role_add.jsp
        if (b){
            req.setAttribute("type", "success");
            req.setAttribute("tips", "添加成功！");
            req.getRequestDispatcher("RoleListServlet").forward(req, resp);
        } else {
            req.setAttribute("type", "error");
            req.setAttribute("tips", "添加失败！");
            req.getRequestDispatcher("RoleListServlet").forward(req, resp);
        }
    }
}
