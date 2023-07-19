package com.qfedu.test.dao;

import com.qfedu.mtlms.dao.ManagerDAO;
import com.qfedu.mtlms.dto.Manager;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * ManagerDAO test the class
 */
public class ManagerDAOTest {
    private ManagerDAO managerDAO = new ManagerDAO();

    @Test
    public void selectManagerByLoginName(){
        Manager manager = managerDAO.selectManagerByLoginName("admin");
        assertNotNull(manager);
    }

    @Test
    public void insertManager(){
        Manager manager = new Manager("10000006", "wangwu", "4297f44b13955235245b2497399d7a93", "王五", "男", "13232326643", "wangwu@gmail.com", "204810234", new Date());
        int i = managerDAO.insertManager(manager);
        System.out.println(i);
    }
    @Test
    public void insertMgrAndRole(){
        int i = managerDAO.insertMgrAndRole("10000006", 1);
        System.out.println(i);
    }
    @Test
    public void updateManager(){
        Manager manager = new Manager("10000007", "zhaoliu", "123123", "赵六", "女", "13434343434", "udsuduf@qq.com", "178786", new Date());
        managerDAO.updateManager(manager);
    }
}