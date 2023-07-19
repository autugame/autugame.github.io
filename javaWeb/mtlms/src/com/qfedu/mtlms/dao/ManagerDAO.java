package com.qfedu.mtlms.dao;

import com.qfedu.mtlms.dto.Manager;
import com.qfedu.mtlms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO {
    /**
     * Query the administrator information based on the administrator login name.
     * @param loginName Administrator login name.
     * @return Manager object
     */
    public Manager selectManagerByLoginName(String loginName){
        Manager manager = null;
        try {
            //1.sql
            String sql = "select mgr_id mgrId,login_name loginName,login_pwd loginPwd,mgr_name mgrName,mgr_gender mgrGender,mgr_tel mgrTel,mgr_email mgrEmail,mgr_qq mgrQQ,create_time createTime from tb_managers where login_name=?;";
            //2.QueryRunner
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            //3.Sql is executed through 'queryRunner'
            manager = queryRunner.query(sql, new BeanHandler<>(Manager.class), loginName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return manager;
    }

    /**
     * Example Query information about all administrator.
     * @return
     */
    public List<Manager> selectAllManagers(){
        List<Manager> managerList = new ArrayList<>();
        try {
            String sql = "select mgr_id mgrId,login_name loginName,login_pwd loginPwd,mgr_name mgrName,mgr_gender mgrGender,mgr_tel mgrTel,mgr_email mgrEmail,mgr_qq mgrQQ,create_time createTime from tb_managers";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            managerList = queryRunner.query(sql, new BeanListHandler<>(Manager.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return managerList;
    }

    /**
     * Add admin
     * @return
     */
    public int insertManager(Manager manager){
        int i = 0;
        try {
            String sql = "insert into tb_managers(mgr_id,login_name,login_pwd,mgr_name,mgr_gender,mgr_tel,mgr_email,mgr_qq,create_time) values(?,?,?,?,?,?,?,?,?)";
            Object[] params = {manager.getMgrId(), manager.getLoginName(), manager.getLoginPwd(), manager.getMgrName(), manager.getMgrGender(), manager.getMgrTel(), manager.getMgrEmail(), manager.getMgrQQ(), manager.getCreateTime()};
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Save the administrator and role.
     * @param mgrId
     * @param roleId
     * @return
     */
    public int insertMgrAndRole(String mgrId, int roleId){
        int i = 0;
        try {
            String sql = "insert into tb_mgr_role(mgr_id, role_id) value(?,?)";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, mgrId, roleId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Delete the administrator and role id based on the administrator id.
     * @param mgrId
     * @return
     */
    public int deleteMgrAndRole(String mgrId){
        int i = 0;
        try {
            String sql = "delete from tb_mgr_role where mgr_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, mgrId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Delete the administrator information based on the administrator id.
     * @param mgrId
     * @return
     */
    public int deleteManager(String mgrId){
        int i = 0;
        try {
            String sql = "delete from tb_managers where mgr_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, mgrId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Query the administrator information based on the administrator id.
     * @param mgrId
     * @return
     */
    public Manager selectManagerById(String mgrId){
        Manager manager = null;
        try {
            String sql = "select mgr_id mgrId,login_name loginName,login_pwd loginPwd,mgr_name mgrName,mgr_gender mgrGender,mgr_tel mgrTel,mgr_email mgrEmail,mgr_qq mgrQQ,create_time createTime from tb_managers where mgr_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            manager = queryRunner.query(sql, new BeanHandler<>(Manager.class), mgrId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return manager;
    }

    /**
     * Modify the administrator information based on the administrator id.
     * @param manager
     * @return
     */
    public int updateManager(Manager manager){
        int i = 0;
        try {
            String sql = "update tb_managers set login_name=?,login_pwd=?,mgr_name=?,mgr_gender=?,mgr_tel=?,mgr_email=?,mgr_qq=? where mgr_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            Object[] params = {manager.getLoginName(), manager.getLoginPwd(), manager.getMgrName(), manager.getMgrGender(), manager.getMgrTel(), manager.getMgrEmail(), manager.getMgrQQ(), manager.getMgrId()};
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
