package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.BasicInfo;
import com.qfedu.mtlms.dto.InfoDetail;
import com.qfedu.mtlms.service.BasicInfoService;
import com.qfedu.mtlms.service.InfoDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Query category and option information.
 */
@WebServlet("/BasicInfoAndDetailListServlet")
public class BasicInfoAndDetailListServlet extends HttpServlet {
    private static final BasicInfoService BASIC_INFO_SERVICE = new BasicInfoService();
    private static final InfoDetailService INFO_DETAIL_SERVICE = new InfoDetailService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Query all evaluation categories.
        List<BasicInfo> basicInfoList = BASIC_INFO_SERVICE.listBasicInfo();

        //2.Traversal category.
        for (BasicInfo basicInfo : basicInfoList){
            //Query options.
            List<InfoDetail> infoDetailist = INFO_DETAIL_SERVICE.listDetailByBasicInfo(basicInfo.getBasicInfoId());
            //Storage options.
            basicInfo.setInfoDetailList(infoDetailist);
        }

        //3.Transitive set.
        req.setAttribute("basicInfoList", basicInfoList);
        req.getRequestDispatcher("products_add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
