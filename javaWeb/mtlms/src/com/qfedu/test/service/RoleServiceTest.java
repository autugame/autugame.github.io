package com.qfedu.test.service;

import com.qfedu.mtlms.dto.Role;
import com.qfedu.mtlms.service.RoleService;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleServiceTest {
    private static final RoleService ROLE_SERVICE = new RoleService();
    @Test
    public void addRole() {
        String[] menuIds = {"1", "2", "3"};
        boolean b = ROLE_SERVICE.addRole(new Role(0, "客服7", "999"), menuIds);
        System.out.println(b);
    }
    @Test
    public void deleteRole(){
        boolean b = ROLE_SERVICE.deleteRole(18);
        System.out.println(b);
    }
}