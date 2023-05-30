package com.qfedu.sgms.servlets;

import com.qfedu.sgms.dao.StudentDAO;
import com.qfedu.sgms.dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收学号和密码
        String stuNum = req.getParameter("stuNum");
        String stuPwd = req.getParameter("stuPwd");

        //2,调用studentdao中的方法
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = studentDAO.queryStudentByNumAndPwd(stuNum, stuPwd);

        //根据登录验证的不同结果，响应给客户端不同的页面
        if (studentDTO == null) {
            //登录失败响应客户端登录页面
            //在当前servlet的dopost方法转发也会转发到下一个dopost
            req.setAttribute("tips", "登录失败，学号或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            //登陆成功将学生信息存放到session
            HttpSession session = req.getSession();
            session.setAttribute("stu", studentDTO);
            //登录成功响应客户端系统主页
            resp.sendRedirect("index.jsp");
        }
    }
}
