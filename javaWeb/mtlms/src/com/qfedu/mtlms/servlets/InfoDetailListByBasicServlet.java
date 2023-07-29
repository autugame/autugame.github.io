package com.qfedu.mtlms.servlets;

import com.google.gson.Gson;
import com.qfedu.mtlms.dto.InfoDetail;
import com.qfedu.mtlms.service.InfoDetailService;
import com.qfedu.mtlms.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Evaluation options under the query category.
 */
@WebServlet("/InfoDetailListByBasicServlet")
public class InfoDetailListByBasicServlet extends HttpServlet {
    private static final InfoDetailService INFO_DETAIL_SERVICE = new InfoDetailService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receiving category id.
        int basicInfoId = Integer.parseInt(req.getParameter("basicInfoId"));
        //Query options based on category id.
        List<InfoDetail> infoDetailList = INFO_DETAIL_SERVICE.listDetailByBasicInfo(basicInfoId);
        //Respond to Ajax requests.
        ResultVO resultVO = infoDetailList!=null?new ResultVO(1, "success", infoDetailList):new ResultVO(0, "fail");
        String jsonStr = new Gson().toJson(resultVO);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }
}
