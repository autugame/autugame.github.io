package com.qfedu.sgms.dao;

import com.qfedu.sgms.dto.StudentDTO;
import com.qfedu.sgms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class StudentDAO {
    public StudentDTO queryStudentByNumAndPwd(String stuNum, String stuPwd){
        StudentDTO student = null;
        try{
            String sql = "select stu_num stuNum,stu_name stuName,stu_gender stuGender,stu_age stuAge,stu_pwd stuPwd from students where stu_num=? and stu_pwd=?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            student = queryRunner.query(sql, new BeanHandler<StudentDTO>(StudentDTO.class), stuNum, stuPwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }
}
