package com.qfedu.mtlms.dao;

import com.qfedu.mtlms.dto.Goods;
import com.qfedu.mtlms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Complete the database operation of the goods.
 */
public class GoodsDAO {
    private static final QueryRunner QUERY_RUNNER = new QueryRunner(DruidUtils.getDataSource());
    /**
     * Query goods information under this brand based on its brand id.
     * @param brandId
     * @return
     */
    public List<Goods> selectGoods(int brandId){
        List<Goods> goodsList = new ArrayList<>();
        try {
            String sql = "select good_id goodId,good_name goodName,good_img goodImg,good_cost goodCost,good_min_price goodMinPrice from tb_good g inner join tb_brand_good bg on g.good_id=bg.fk_good_id where fk_brand_id=?";
            goodsList = QUERY_RUNNER.query(sql, new BeanListHandler<>(Goods.class), brandId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goodsList;
    }
}
