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

/**
 * Add evaluation options.
 */
@WebServlet("/InfoDetailAddServlet")
public class InfoDetailAddServlet extends HttpServlet {
    private static final InfoDetailService INFO_DETAIL_SERVICE = new InfoDetailService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receive evaluation option information.
        int basicInfoId = Integer.parseInt(req.getParameter("basicInfoId"));
        String infoDetailName = req.getParameter("infoDetailName");
        String infoDetailDesc = req.getParameter("infoDetailDesc");
        InfoDetail infoDetail = new InfoDetail(0, infoDetailName, infoDetailDesc);

        //Save evaluation information.
        boolean b = INFO_DETAIL_SERVICE.saveInfoDetail(infoDetail, basicInfoId);

        //Responding to ajax requests.
        ResultVO resultVO = b?new ResultVO(1, "success"):new ResultVO(0, "fail");
        String jsonStr = new Gson().toJson(resultVO);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }
}
