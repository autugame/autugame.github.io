package com.qfedu.mtlms.dao;

import com.qfedu.mtlms.dto.BasicInfo;
import com.qfedu.mtlms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Category database access operations.
 */
public class BasicInfoDAO {
    private static final QueryRunner QUERY_RUNNER = new QueryRunner(DruidUtils.getDataSource());

    /**
     * Query the list of all evaluation categories.
     * @return
     */
    public List<BasicInfo> selectBasicInfos(){
        List<BasicInfo> basicInfoList = new ArrayList<>();
        try {
            String sql = "select basic_info_id basicInfoId,basic_info_name basicInfoName,basic_info_status basicInfoStatus from tb_basic_info";
            basicInfoList = QUERY_RUNNER.query(sql, new BeanListHandler<>(BasicInfo.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return basicInfoList;
    }

    /**
     * Add category information to the database.
     * @param basicInfo
     * @return
     */
    public int insertBasicInfo(BasicInfo basicInfo) {
        int i = 0;
        try {
            String sql = "insert into tb_basic_info(basic_info_name,basic_info_status) values(?,?)";
            i = QUERY_RUNNER.update(sql, basicInfo.getBasicInfoName(), basicInfo.getBasicInfoStatus());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
