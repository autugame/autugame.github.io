package com.qfedu.mtlms.service;


import com.qfedu.mtlms.dao.MenuDAO;
import com.qfedu.mtlms.dto.Manager;
import com.qfedu.mtlms.dto.Menu1;
import com.qfedu.mtlms.dto.Menu2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Menu business processing.
 */
public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    /**
     * Query the current administrator menu based on the administrator ID.
     *
     * @param mgrId Administrator ID.
     * @return Menu List.
     */
    public List<Menu1> listMenusByMgrId(String mgrId) {
        //1.Query all level-1 menus based on the administrator ID.
        List<Menu1> menuList = menuDAO.selectFirstLevelMenuByMgrId(mgrId);
        //1.Query the level 2 menu in the level 1 menu.
        for (Menu1 menu : menuList) {
            //Query the level-2 menu
            menu.setChildMenus(menuDAO.selectSecondLevelMenusByMgrIdAndParentCode(mgrId, menu.getMenuCode()));
        }
        return menuList;
    }

    /**
     * Query level-1 and level-2 menus.
     */
    public Map<String, List> listMenus() {
        //1.Query level-1 menus.
        List<Menu1> menu1List = menuDAO.selectMenu1();
        //2.Query level-2 menus.
        List<Menu2> menu2List = menuDAO.selectMenu2();
        //Store 'menu1List' and 'menu2List' in map.
        Map<String, List> menus = new HashMap<>();
        menus.put("menu1List", menu1List);
        menus.put("menu2List", menu2List);
        return menus;
    }

    /**
     * Query the level-2 menus based on the level-1 menu code.
     *
     * @param menu1Code Menu code.
     * @return Menu2 object list.
     */
    public List<Menu2> listMenu2ByMenu1Code(String menu1Code) {
        List<Menu2> menu2List = menuDAO.selectMenu2ByMenu1Code(menu1Code);
        return menu2List;
    }

    /**
     * enable menu
     *
     * @param menuCode
     * @return true or false
     */
    public boolean enableMenu(String menuCode) {
        return changeMenuState(menuCode, 1);
    }

    /**
     * disable menu
     *
     * @param menuCode
     * @return true or false
     */
    public boolean disableMenu(String menuCode) {
        return changeMenuState(menuCode, 0);
    }

    private boolean changeMenuState(String menuCode, int state) {
        int i = menuDAO.updateMenuState(menuCode, state);
        return i > 0;
    }

    /**
     * Query all level 1 menus and contain level 2 menus.
     *
     * @return Level 1 menus list.
     */
    public List<Menu1> listAllMenus() {
        //Query all level 1 menus.
        List<Menu1> menu1List = menuDAO.selectMenu1();
        //Traverse the level 1 menu.
        for (Menu1 menu : menu1List) {
            //Query the level 2 list based on the level 1 menu 'menuCode'.
            List<Menu2> menu2s = menuDAO.selectMenu2ByMenu1Code(menu.getMenuCode());
            //Displace the searched level 2 menu into tue current level 1 menu object.
            menu.setChildMenus(menu2s);
        }
        return menu1List;
    }
}
