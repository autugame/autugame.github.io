package com.qfedu.mtlms.service;

import com.qfedu.mtlms.dao.GoodsDAO;
import com.qfedu.mtlms.dto.Goods;

import java.util.List;

public class GoodsService {
        private static final GoodsDAO GOODS_DAO = new GoodsDAO();
    /**
     * Query product list based on brand id.
     * @return
     */
    public List<Goods> listGoodsByBrandId(int brandId) {
        return GOODS_DAO.selectGoods(brandId);
    }

    /**
     * Save product information and brand association.
     * @param goods
     * @return
     */
    public int saveGoods(Goods goods, int brandId) {
        //Save product information
        int goodsId = GOODS_DAO.insertGoods(goods);
        if (goodsId > 0){
            //Save association relationship.
            int i = GOODS_DAO.insertGoodsAndBrand(goodsId, brandId);
            if (i > 0){
                return goodsId;
            }
        }
        return 0;
    }

    /**
     * Save the relationship between products and options.
     * @param goodsId
     * @param infoDetailId
     * @param price
     * @return
     */
    public boolean saveGoodsAndInfoDetail(int goodsId, int infoDetailId, int price) {
        int i = GOODS_DAO.insertGoodsAndInfoDetail(goodsId, infoDetailId, price);
        return i > 0;
    }
}
