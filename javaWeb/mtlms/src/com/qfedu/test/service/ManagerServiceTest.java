package com.qfedu.test.service;

import com.qfedu.mtlms.dto.Manager;
import com.qfedu.mtlms.service.ManagerService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ManagerService test the class.
 */
public class ManagerServiceTest {
    private ManagerService managerService = new ManagerService();
    @Test
    public void checkLogin(){
        Manager manager = managerService.checkLogin("admin", "4297f44b13955235245b2497399d7a93");
//        assertEquals(null, manager);
        assertNotNull(manager);
    }
    @Test
    public void listManagers(){
        List<Manager> managers = managerService.listManagers();
        System.out.println();
    }
    @Test
    public void getManagerById(){
        Manager manager = managerService.getManagerById("10000007");
        System.out.println(manager);
    }
    @Test
    public void updateManager(){
        Manager manager = new Manager("10000007", "zhaoliu", "123123", "赵六", "男", "13434343434", "udsuduf@qq.com", "178786", new Date());
        boolean b = managerService.updateManager(manager, 30);
        System.out.println(b);
    }
}