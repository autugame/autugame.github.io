package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Goods;
import com.qfedu.mtlms.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Add product information.
 */
@WebServlet("/GoodsAddServlet")
public class GoodsAddServlet extends HttpServlet {
    private static final GoodsService GOODS_SERVICE = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receive product information.
        String goodsName = req.getParameter("goodsName");
        String goodsImgPath = req.getParameter("goodsImgPath");
        int goodsCost = Integer.parseInt(req.getParameter("goodsCost"));
        int goodsMinPrice = Integer.parseInt(req.getParameter("goodsMinPrice"));
        Goods goods = new Goods(0, goodsName, goodsImgPath, goodsCost, goodsMinPrice);
        //Receive brand id.
        int brandId = Integer.parseInt(req.getParameter("brandId"));
        //Save product information.
        int goodsId = GOODS_SERVICE.saveGoods(goods, brandId);
        //Receive the id of the selected evaluation option.
        String[] infoDetailIds = req.getParameterValues("infoDetailId");
        //Traverse each evaluation option to obtain a price.
        for (int i = 0; i < infoDetailIds.length; i++){
            int infoDetailId = Integer.parseInt(infoDetailIds[i]);
            int price = Integer.parseInt(req.getParameter("price_"+infoDetailId));
            //Save the relationship between products and options.
            boolean b = GOODS_SERVICE.saveGoodsAndInfoDetail(goodsId, infoDetailId, price);
        }

        if(goodsId > 0){
            req.setAttribute("type", "success");
            req.setAttribute("tips", "添加成功！");
            req.getRequestDispatcher("products_list.jsp").forward(req, resp);
        } else {
            req.setAttribute("type", "error");
            req.setAttribute("tips", "添加失败！");
            req.getRequestDispatcher("products_list.jsp").forward(req, resp);
        }
    }
}
