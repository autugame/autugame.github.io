package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Manager;
import com.qfedu.mtlms.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * The servlet used to complete the administrator login.
 */
@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("type", "warning");
        req.setAttribute("tips", "谁叫你直接访问servlet的!");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Receiving account, password, and check code.
        String loginName = req.getParameter("loginName");
        String loginPassword = req.getParameter("loginPassword");
        String checkCode = req.getParameter("checkCode");

        //Check verification code.
        HttpSession session = req.getSession();
        //Retrieves the verification code from session.
        String vCode = (String) session.getAttribute("vCode");
        //Verify the administrator enters the verification code.
        if (!checkCode.equals(vCode)){
            //Verification code error.
            req.setAttribute("type", "error");
            req.setAttribute("tips", "验证码错误！");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            //Correct verification code.
            //2.Invoke manager service validation.
            ManagerService managerService = new ManagerService();
            Manager manager = managerService.checkLogin(loginName, loginPassword);

            //3.Judgment check result.
            if (manager == null){
                //login failed with an error message.
                req.setAttribute("type", "error");
                req.setAttribute("tips", "登录失败，账号或密码错误！");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else{
                //Store administrator information.
                session.setAttribute("mgr", manager);
                //The login succeeds and the home page is displayed
                //resp.sendRedirect("index.jsp");
                resp.sendRedirect("IndexServlet");
            }
        }
    }
}
