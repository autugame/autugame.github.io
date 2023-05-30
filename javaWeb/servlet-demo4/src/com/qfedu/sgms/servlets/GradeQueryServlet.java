package com.qfedu.sgms.servlets;

import com.qfedu.sgms.dao.GradeDAO;
import com.qfedu.sgms.dto.GradeDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GradeQueryServlet")
public class GradeQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //允许两种请求方式提交
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello");
        //接收客户端输入的学号和课程ID
        String sNum = req.getParameter("stuNum");
        String cid = req.getParameter("courseId");

        //调用gradeDAO中的方法，根据学号和课程号查询成绩
        GradeDAO gradeDAO = new GradeDAO();
        GradeDTO gradeDTO = gradeDAO.queryGradeBySNumAndCid(sNum, cid);

        //将成绩转发到gradePageServlet
        req.setAttribute("grade", gradeDTO);
        req.getRequestDispatcher("grade-show.jsp").forward(req, resp);
    }
}
