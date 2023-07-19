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
 * Query role information.
 */
@WebServlet("/RoleUpdateServlet")
public class RoleUpdateServlet extends HttpServlet {
    private static final RoleService ROLE_SERVICE = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receiving role information.
        req.setCharacterEncoding("utf-8");
        String roleId = req.getParameter("roleId");
        String roleName = req.getParameter("roleName");
        String roleDesc = req.getParameter("roleDesc");
        Role role = new Role(Integer.parseInt(roleId), roleName, roleDesc);

        //Receiving menu id.
        String[] menuIds = req.getParameterValues("menuId");

        //Perform modification.
        boolean b = ROLE_SERVICE.updateRole(role, menuIds);

        //4.Jump to admin_role_list.jsp
        if (b){
            req.setAttribute("type", "success");
            req.setAttribute("tips", "修改成功！");
            req.getRequestDispatcher("RoleListServlet").forward(req, resp);
        } else {
            req.setAttribute("type", "error");
            req.setAttribute("tips", "修改失败！");
            req.getRequestDispatcher("RoleListServlet").forward(req, resp);
        }
    }
}
