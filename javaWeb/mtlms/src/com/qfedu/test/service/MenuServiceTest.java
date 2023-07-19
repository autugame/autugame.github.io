package com.qfedu.test.service;

import com.qfedu.mtlms.dto.Menu1;
import com.qfedu.mtlms.dto.Menu2;
import com.qfedu.mtlms.service.MenuService;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MenuServiceTest {
    private static final MenuService menuService = new MenuService();
    @Test
    public void testListMenusByMgrId() {
        for (Menu1 menu1:menuService.listMenusByMgrId("10000001")){
            System.out.println(menu1);
            for (Menu2 menu2:menu1.getChildMenus()){
                System.out.println(menu2);
            }
        }
    }
    @Test
    public void testListMenus(){
        Map<String, List> menusMap = menuService.listMenus();
        List<Menu1> menu1List = menusMap.get("menu1List");
        List<Menu2> menu2List = menusMap.get("menu2List");
        System.out.println();
    }
    @Test
    public void testListMenu2ByMenu1Code(){
        List<Menu2> menu2List = menuService.listMenu2ByMenu1Code("01");
        System.out.println();
    }
    @Test
    public void testEnableMenu(){
        boolean b = menuService.enableMenu("0101");
        assertTrue(b);
    }
    @Test
    public void testDisableMenu(){
        boolean b = menuService.disableMenu("0101");
        assertTrue(b);
    }
    @Test
    public void listAllMenus(){
        List<Menu1> menu1s = menuService.listAllMenus();
        System.out.println(menu1s);
    }
}