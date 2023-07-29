package com.qfedu.mtlms.dao;

import com.qfedu.mtlms.dto.InfoDetail;
import com.qfedu.mtlms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Database operations regarding evaluation options.
 */
public class InfoDetailDAO {
    private static final QueryRunner QUERY_RUNNER = new QueryRunner(DruidUtils.getDataSource());
    /**
     * Query all options under this evaluation category based on the evaluation category id.
     * @return
     */
    public List<InfoDetail> selectInfoDetailsByBasicInfo(int basicInfoId){
        List<InfoDetail> infoDetailList = new ArrayList<>();
        try {
            String sql = "select info_detail_id infoDetailId,info_detail_name infoDetailName,info_detail_desc infoDetailDesc from tb_info_detail where fk_basic_info_id=?";
            infoDetailList = QUERY_RUNNER.query(sql, new BeanListHandler<>(InfoDetail.class), basicInfoId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return infoDetailList;
    }

    /**
     * Add evaluation options.
     * @param infoDetail
     * @param basicInfoId
     * @return
     */
    public int insertInfoDetail(InfoDetail infoDetail, int basicInfoId){
        int i = 0;
        try {
            String sql = "insert into tb_info_detail(info_detail_name, info_detail_desc, fk_basic_info_id) value(?,?,?)";
            i = QUERY_RUNNER.update(sql, infoDetail.getInfoDetailName(), infoDetail.getInfoDetailDesc(), basicInfoId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
