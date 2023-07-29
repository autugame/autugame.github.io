package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.BasicInfo;
import com.qfedu.mtlms.service.BasicInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Add evaluation category.
 */
@WebServlet("/BasicInfoAddServlet")
public class BasicInfoAddServlet extends HttpServlet {
    private static final BasicInfoService BASIC_INFO_SERVICE = new BasicInfoService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receiving category name.
        req.setCharacterEncoding("utf-8");
        String basicInfoName = req.getParameter("basicInfoName");
        BasicInfo basicInfo = new BasicInfo(0, basicInfoName, 1);
        //Save category information.
        boolean b = BASIC_INFO_SERVICE.saveBasicInfo(basicInfo);
        if (b){
            req.setAttribute("type", "success");
            req.setAttribute("tips", "添加成功！");
            req.getRequestDispatcher("BasicInfoListServlet").forward(req, resp);
        } else {
            req.setAttribute("type", "error");
            req.setAttribute("tips", "添加失败！");
            req.getRequestDispatcher("BasicInfoListServlet").forward(req, resp);
        }
    }
}
