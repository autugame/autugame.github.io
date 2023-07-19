package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Delete in batches.
 */
@WebServlet("/RoleMultiDeleteServlet")
public class RoleMultiDeleteServlet extends HttpServlet {
    private static final RoleService ROLE_SERVICE = new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receiving role id.
        String[] roleIds = req.getParameterValues("roleId");
        //Traverse the role id.
        //Id of the role that failed to be deleted.
        List<Integer> failIds = new ArrayList<>();
        for (String roleId:roleIds){
            int id = Integer.parseInt(roleId);
            boolean b = ROLE_SERVICE.deleteRole(id);
            if (!b){
                failIds.add(id);
            }
        }
        //Prompt message.
        StringBuilder ids = new StringBuilder();
        for (Integer id:failIds){
            if (ids == null || "".equals(ids)){
                ids.append(id);
            } else {
                ids.append(",").append(id);
            }
        }
        if (failIds.size() == 0){
            req.setAttribute("type", "success");
            req.setAttribute("tips", "删除成功！");
        } else {
            req.setAttribute("type", "error");
            req.setAttribute("tips", "删除失败！" + ids);
        }
        req.getRequestDispatcher("RoleListServlet").forward(req, resp);
    }
}
