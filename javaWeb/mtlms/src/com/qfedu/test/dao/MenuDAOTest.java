package com.qfedu.test.dao;

import com.qfedu.mtlms.dao.MenuDAO;
import com.qfedu.mtlms.dto.Menu1;
import com.qfedu.mtlms.dto.Menu2;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class MenuDAOTest {
    private static final MenuDAO menuDAO = new MenuDAO();
    @Test
    public void testSelectFirstLevelMenuByMgrId() {
        List<Menu1> menuList = menuDAO.selectFirstLevelMenuByMgrId("10000001");
        assertEquals(9, menuList.size());
        for (Menu1 menu:menuList){
            System.out.println(menu);
        }
    }
    @Test
    public void testSelectSecondLevelMenusByMgrIdAndParentCode(){
        List<Menu2> menuList = menuDAO.selectSecondLevelMenusByMgrIdAndParentCode("10000001", "01");
        assertEquals(3, menuList.size());
        for (Menu2 menu:menuList){
            System.out.println(menu);
        }
    }
    @Test
    public void testSelectMenu1(){
        List<Menu1> menu1s = menuDAO.selectMenu1();
        for (Menu1 menu:menu1s){
            System.out.println(menu);
        }
    }
    @Test
    public void testSelectMenu2(){
        List<Menu2> menu2s = menuDAO.selectMenu2();
        for (Menu2 menu:menu2s){
            System.out.println(menu);
        }
    }
    @Test
    public void testSelectMenu2ByMenu1Code(){
        List<Menu2> menu2s = menuDAO.selectMenu2ByMenu1Code("01");
        for (Menu2 menu:menu2s){
            System.out.println(menu);
        }
    }
    @Test
    public void testUpdateMenuState(){
        assertEquals(1, menuDAO.updateMenuState("0101", 1));
    }
}