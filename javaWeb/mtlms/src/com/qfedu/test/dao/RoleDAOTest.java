package com.qfedu.test.dao;

import com.qfedu.mtlms.dao.RoleDAO;
import com.qfedu.mtlms.dto.Role;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RoleDAOTest {
    private static final RoleDAO roleDAO = new RoleDAO();

    @Test
    public void selectRoles() {
        List<Role> roles = roleDAO.selectRoles();
        System.out.println(roles);
    }

    @Test
    public void insertRole(){
        int i = roleDAO.insertRole(new Role(0, "客服4", "666"));
        System.out.println(i);
    }
    @Test
    public void insertRoleAndMenu(){
        int i = roleDAO.insertRoleAndMenu(5, 1);
        System.out.println(i);
    }
    @Test
    public void deleteRoleAndMenuByRoleId(){
        int i = roleDAO.deleteRoleAndMenuByRoleId(23);
        System.out.println(i);
    }
    @Test
    public void deleteRoleByRoleId(){
        int i = roleDAO.deleteRoleByRoleId(23);
        System.out.println(i);
    }
    @Test
    public void selectRoleById(){
        Role role = roleDAO.selectRoleById(1);
        System.out.println(role);
    }
    @Test
    public void selectMenuIdsByRoleId(){
        List<Integer> integers = roleDAO.selectMenuIdsByRoleId(1);
        System.out.println(integers);
    }
    @Test
    public void updateRole(){
        roleDAO.updateRole(new Role(30, "客服10", "111"));
    }
}