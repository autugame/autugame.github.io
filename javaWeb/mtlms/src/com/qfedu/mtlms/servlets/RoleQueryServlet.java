package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Menu1;
import com.qfedu.mtlms.dto.Menu2;
import com.qfedu.mtlms.dto.Role;
import com.qfedu.mtlms.service.MenuService;
import com.qfedu.mtlms.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Query role information.
 */
@WebServlet("/RoleQueryServlet")
public class RoleQueryServlet extends HttpServlet {
    private static final RoleService ROLE_SERVICE = new RoleService();
    private static final MenuService MENU_SERVICE = new MenuService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receiving id.
        String rid = req.getParameter("roleId");
        int roleId = rid==null?0:Integer.parseInt(rid);

        //Query role information based on the role id.
        Role role = ROLE_SERVICE.getRoleById(roleId);

        //Query the permission menu list.
        List<Menu1> menuList = MENU_SERVICE.listAllMenus();

        //Example Query the permission id.
        List<Integer> menuIds = ROLE_SERVICE.getMenuIdsByRoleId(roleId);

        //Determine which menu of all menus is owned.
        for (Menu1 menu1:menuList){
            //If this permission is included in the permission list, mark it.

            if (menuIds.contains(menu1.getMenuId())){
                menu1.setHaveMenu(true);
            }
            for (Menu2 menu2:menu1.getChildMenus()){
                if (menuIds.contains(menu2.getMenuId())){
                    menu2.setHaveMenu(true);
                }
            }
        }
        //Pass role information and menu collections to the page.
        req.setAttribute("role", role);
        req.setAttribute("menuList", menuList);
        req.getRequestDispatcher("admin_role_modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
