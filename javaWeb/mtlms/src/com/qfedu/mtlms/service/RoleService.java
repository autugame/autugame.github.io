package com.qfedu.mtlms.service;

import com.qfedu.mtlms.dao.RoleDAO;
import com.qfedu.mtlms.dto.Role;

import java.util.List;

public class RoleService {
    private static final RoleDAO ROLE_DAO = new RoleDAO();

    /**
     * Call the dao to query list of roles.
     * @return roles list.
     */
    public List<Role> getRoles(){
        return ROLE_DAO.selectRoles();
    }

    /**
     * Adding role information.
     * @param role Role object.
     * @param menuIds Menu id.
     * @return true or false
     */
    public boolean addRole(Role role, String[] menuIds){
        boolean b = false;
        //1.Save role information To obtain the generated role id.
        if (!role.getRoleName().equals("") && !role.getRoleDesc().equals("") && menuIds != null){
            int roleId = ROLE_DAO.insertRole(role);
            //2.Saves the association between the role and the menu.
            for (String id : menuIds) {
                int menuId = Integer.parseInt(id);
                int j = ROLE_DAO.insertRoleAndMenu(roleId, menuId);
                b = j > 0;
            }
        }
        return b;
    }

    /**
     * Delete the role information based on the role id.
     * @param roleId
     * @return
     */
    public boolean deleteRole(int roleId){
        int i = ROLE_DAO.deleteRoleAndMenuByRoleId(roleId);
        int j = ROLE_DAO.deleteRoleByRoleId(roleId);
        return i > 0 && j > 0;
    }

    /**
     * Query role information based on the role id.
     * @param roleId
     * @return
     */
    public Role getRoleById(int roleId){
        return ROLE_DAO.selectRoleById(roleId);
    }

    /**
     * Query the rights of a role based on the role id.
     * @param roleId
     * @return
     */
    public List<Integer> getMenuIdsByRoleId(int roleId){
        return ROLE_DAO.selectMenuIdsByRoleId(roleId);
    }

    /**
     * Modify role information.
     * @param role
     * @param menuIds
     * @return
     */
    public boolean updateRole(Role role, String[] menuIds){
        //Modify role information.
        int i = ROLE_DAO.updateRole(role);
        //Example Delete the original permission of a role.
        int j = ROLE_DAO.deleteRoleAndMenuByRoleId(role.getRoleId());
        //Adds all the selected permission.
        int m = 0;
        for (String menuId:menuIds){
            int id = Integer.parseInt(menuId);
            m = ROLE_DAO.insertRoleAndMenu(role.getRoleId(), id);
        }
        return i>0&&j>0&&m>0;
    }
}
