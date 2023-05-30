package com.qfedu.sgms.dao;

import com.qfedu.sgms.dto.GradeDTO;
import com.qfedu.sgms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class GradeDAO {
    public GradeDTO queryGradeBySNumAndCid(String sNum, String cid){
        GradeDTO grade = null;
        try{
            //查询出的列名要取别名和属性一致
            String sql = "select s.stu_num sNum,s.stu_name sName,c.course_id cid,c.course_name cName,g.score score " +
                    "from students s INNER JOIN grades g INNER JOIN courses c " +
                    "on s.stu_num = g.snum and g.cid = c.course_id " +
                    "where s.stu_num = ? and c.course_id = ?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            grade = queryRunner.query(sql, new BeanHandler<GradeDTO>(GradeDTO.class), sNum, cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return grade;
    }
}
