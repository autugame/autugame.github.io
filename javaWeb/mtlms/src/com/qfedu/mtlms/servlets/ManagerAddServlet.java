package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Manager;
import com.qfedu.mtlms.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Add admin.
 */
@WebServlet("/ManagerAddServlet")
public class ManagerAddServlet extends HttpServlet {
    private static final ManagerService MANAGER_SERVICE = new ManagerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receive the input administrator information.
        req.setCharacterEncoding("utf-8");
        String mgrId = req.getParameter("mgrId");
        String loginName = req.getParameter("loginName");
        String loginPwd = req.getParameter("loginPwd");
        String mgrName = req.getParameter("mgrName");
        String mgrGender = req.getParameter("mgrGender");
        String mgrTel = req.getParameter("mgrTel");
        String mgrEmail = req.getParameter("mgrEmail");
        String mgrQQ = req.getParameter("mgrQQ");
        String roleId = req.getParameter("roleId");
        Manager manager = new Manager(mgrId, loginName, loginPwd, mgrName, mgrGender, mgrTel, mgrEmail, mgrQQ, new Date());
        //Save administrator information.
        boolean b = MANAGER_SERVICE.saveManager(manager, Integer.parseInt(roleId));
        //Return to the list page.
        if (b){
            req.setAttribute("type", "success");
            req.setAttribute("tips", "添加成功！");
            req.getRequestDispatcher("ManagerListServlet").forward(req, resp);
        } else {
            req.setAttribute("type", "error");
            req.setAttribute("tips", "添加失败！");
            req.getRequestDispatcher("ManagerListServlet").forward(req, resp);
        }
    }
}
