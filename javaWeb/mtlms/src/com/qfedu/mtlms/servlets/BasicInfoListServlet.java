package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.BasicInfo;
import com.qfedu.mtlms.service.BasicInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Query evaluation category list.
 */
@WebServlet("/BasicInfoListServlet")
public class BasicInfoListServlet extends HttpServlet {
    private static final BasicInfoService BASIC_INFO_SERVICE = new BasicInfoService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Query the list of all evaluation categories.
        List<BasicInfo> basicInfoList = BASIC_INFO_SERVICE.listBasicInfo();
        //Pass the category list to the list page.
        req.setAttribute("basicInfoList", basicInfoList);
        req.getRequestDispatcher("basic_info_list.jsp").forward(req, resp);
    }
}
