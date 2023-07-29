package com.qfedu.mtlms.servlets;

import com.google.gson.Gson;
import com.qfedu.mtlms.dto.Goods;
import com.qfedu.mtlms.service.GoodsService;
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
 * Query product information.
 */
@WebServlet("/GoodsListForAjaxServlet")
public class GoodsListForAjaxServlet extends HttpServlet {
    private static final GoodsService GOODS_SERVICE = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Received brand id.
        int brandId = Integer.parseInt(req.getParameter("brandId"));
        List<Goods> goodsList =  GOODS_SERVICE.listGoodsByBrandId(brandId);

        //Convert to JSON.
        ResultVO resultVO = goodsList!=null?new ResultVO(1, "success", goodsList):new ResultVO(0, "fail");
        String jsonStr = new Gson().toJson(resultVO);
        //Response to ajax requests.
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }
}
