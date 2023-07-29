package com.qfedu.mtlms.servlets;

import com.google.gson.Gson;
import com.qfedu.mtlms.dto.BasicInfo;
import com.qfedu.mtlms.service.BasicInfoService;
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
 * List of response evaluation categories.
 */
@WebServlet("/BasicInfoLoadServlet")
public class BasicInfoLoadServlet extends HttpServlet {
    private static final BasicInfoService BASIC_INFO_SERVICE = new BasicInfoService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Query evaluation category information.
        List<BasicInfo> basicInfoList = BASIC_INFO_SERVICE.listBasicInfo();
        //2.Responding to Ajax requests.
        ResultVO vo = basicInfoList != null ? new ResultVO(1, "success", basicInfoList):new ResultVO(0, "fail");
        String jsonStr = new Gson().toJson(vo);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }
}
