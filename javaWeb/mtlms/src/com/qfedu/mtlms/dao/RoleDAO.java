package com.qfedu.mtlms.dao;

import com.qfedu.mtlms.dto.Role;
import com.qfedu.mtlms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Role database access operation.
 */
public class RoleDAO {
    /**
     * Query all roles.
     * @return Roles list.
     */
    public List<Role> selectRoles(){
        List<Role> roleList = new ArrayList<>();
        try {
            String sql = "select role_id roleId, role_name roleName, role_desc roleDesc from tb_roles";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            roleList = queryRunner.query(sql, new BeanListHandler<>(Role.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roleList;
    }

    /**
     * Adding role information.
     * @param role Role object.
     * @return success or fail.
     */
    public int insertRole(Role role){
        int i = 0;
        try {
            String sql = "insert into tb_roles(role_name, role_desc) values(?,?);";
            Object[] params = {role.getRoleName(), role.getRoleDesc()};
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            //BigInteger
            BigInteger integer = queryRunner.insert(sql, new ScalarHandler<>(), params);
            i = integer.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Add a role and menu association.
     * @return success or fail.
     */
    public int insertRoleAndMenu(int roleId, int menuId){
        int i = 0;
        try {
            String sql = "insert into tb_role_menu(role_id, menu_id) values(?,?);";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, roleId, menuId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Delete the relationship between a role and menu based on the role id.
     * @param roleId Role id.
     * @return true or false.
     */
    public int deleteRoleAndMenuByRoleId(int roleId){
        int i = 0;
        try {
            String sql = "delete from tb_role_menu where role_id = ?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, roleId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Delete the role information based on the role id.
     * @param roleId Role id.
     * @return true or false.
     */
    public int deleteRoleByRoleId(int roleId){
        int i = 0;
        try {
            String sql = "delete from tb_roles where role_id = ?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, roleId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Query role information based on the role id.
     * @return
     */
    public Role selectRoleById(int roleId){
        Role role = null;
        try {
            String sql = "select role_id roleId,role_name roleName,role_desc roleDesc from tb_roles where role_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            role = queryRunner.query(sql, new BeanHandler<>(Role.class), roleId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return role;
    }

    /**
     * Query the permission id fo the current role based on the role id.
     * @param roleId
     * @return
     */
    public List<Integer> selectMenuIdsByRoleId(int roleId){
        List<Integer> mids = new ArrayList<>();
        try {
            String sql = "select menu_id from tb_role_menu where role_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            //Custom result sets.
            ResultSetHandler<List<Integer>> resultSetHandler = new ResultSetHandler<List<Integer>>(){
                @Override
                public List<Integer> handle(ResultSet resultSet) throws SQLException {
                    List<Integer> list = new ArrayList<>();
                    while(resultSet.next()){
                        int mid = resultSet.getInt("menu_id");
                        list.add(mid);
                    }
                    return list;
                }
            };
            mids = queryRunner.query(sql, resultSetHandler, roleId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mids;
    }

    /**
     * Modify the name and description based on the role id.
     * @param role
     * @return
     */
    public int updateRole(Role role){
        int i = 0;
        try {
            String sql = "update tb_roles set role_name=?,role_desc=? where role_id=?";
            Object[] params = {role.getRoleName(), role.getRoleDesc(), role.getRoleId()};
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
