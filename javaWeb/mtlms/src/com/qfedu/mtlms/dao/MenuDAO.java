package com.qfedu.mtlms.dao;

import com.qfedu.mtlms.dto.Menu1;
import com.qfedu.mtlms.dto.Menu2;
import com.qfedu.mtlms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of menu database operations
 */
public class MenuDAO {
    /**
     * Query the level-1 menu based on the administrator ID.
     * @param mgrId Administrator ID.
     * @return Menu array.
     */
    public List<Menu1> selectFirstLevelMenuByMgrId(String mgrId){
        List<Menu1> menuList = new ArrayList<>();
        try {
            String sql = "select c.menu_id menuId,menu_code menuCode,menu_name menuName,menu_order menuOrder,menu_level menuLevel,menu_icon menuIcon,menu_state menuState from tb_mgr_role a inner join tb_role_menu b inner join tb_menus c on a.role_id=b.role_id and b.menu_id=c.menu_id where mgr_id = ? and menu_level = 1 order by menu_order";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            menuList = queryRunner.query(sql, new BeanListHandler<>(Menu1.class), mgrId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menuList;
    }

    /**
     * Query the level-2 menu based on the administrator id and parent code.
     * @param mgrId
     * @param parentCode
     * @return
     */
    public List<Menu2> selectSecondLevelMenusByMgrIdAndParentCode(String mgrId, String parentCode){
        List<Menu2> menu2List = new ArrayList<>();
        try {
            String sql = "select c.menu_id menuId,menu_code menuCode,menu_name menuName,menu_order menuOrder,menu_level menuLevel,parent_menu_code parentMenuCode,menu_url menuUrl,menu_state menuState from tb_mgr_role a inner join tb_role_menu b inner join tb_menus c on a.role_id=b.role_id and b.menu_id=c.menu_id where mgr_id = ? and menu_level = 2 and parent_menu_code = ? order by menu_order";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            menu2List = queryRunner.query(sql, new BeanListHandler<>(Menu2.class), mgrId, parentCode);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menu2List;
    }

    /**
     * Query all level-1 menu.
     * @return level-1 menu list.
     */
    public List<Menu1> selectMenu1(){
        List<Menu1> menuList = new ArrayList<>();
        try {
            String sql = "select menu_id menuId,menu_code menuCode,menu_name menuName,menu_order menuOrder,menu_level menuLevel,menu_icon menuIcon,menu_state menuState from tb_menus where menu_level = 1 order by menu_order";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            menuList = queryRunner.query(sql, new BeanListHandler<>(Menu1.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menuList;
    }

    /**
     * Query all level-2 menu.
     * @return level-2 menu list.
     */
    public List<Menu2> selectMenu2(){
        List<Menu2> menuList = new ArrayList<>();
        try {
            String sql = "select menu_id menuId,menu_code menuCode,menu_name menuName,menu_order menuOrder,menu_level menuLevel,parent_menu_code parentMenuCode,menu_url menuUrl,menu_state menuState from tb_menus where menu_level = 2 order by menu_order";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            menuList = queryRunner.query(sql, new BeanListHandler<>(Menu2.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menuList;
    }
    public List<Menu2> selectMenu2ByMenu1Code(String parentCode){
        List<Menu2> menuList = new ArrayList<>();
        try {
            String sql = "select menu_id menuId,menu_code menuCode,menu_name menuName,menu_order menuOrder,menu_level menuLevel,parent_menu_code parentMenuCode,menu_url menuUrl,menu_state menuState from tb_menus where parent_menu_code = ? order by menu_order";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            menuList = queryRunner.query(sql, new BeanListHandler<>(Menu2.class), parentCode);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menuList;
    }

    /**
     * modify the menu status based on menu code.
     * @param menuCode
     * @param state
     * @return 0  1
     */
    public int updateMenuState(String menuCode, int state){
        int i = 0;
        try {
            String sql = "update tb_menus set menu_state=? where menu_code=?";
            Object[] params = {state, menuCode};
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
