package com.qfedu.mtlms.service;

import com.qfedu.mtlms.dao.ManagerDAO;
import com.qfedu.mtlms.dto.Manager;
import com.qfedu.mtlms.utils.MD5Utils;

import java.util.List;

/**
 * It is used to implement services related to administrators.
 */
public class ManagerService {
    private static final ManagerDAO MANAGER_DAO = new ManagerDAO();

    /**
     * Verify the login success based on account and password entered by the administrator.
     *
     * @param loginName Administrator login name
     * @param loginPwd  Administrator login password
     * @return Manager object
     */
    public Manager checkLogin(String loginName, String loginPwd) {
        //1.Query administrator information according to login name
        Manager manager = MANAGER_DAO.selectManagerByLoginName(loginName);
        //2.If the query result is not null, the login name is correct
        if (manager != null) {
            //Encrypted password.
            String pwd = MD5Utils.md5Encode(loginPwd);
            //Judgment password
            if (!pwd.equals(manager.getLoginPwd())) {
                return null;
            }
        }
        return manager;
    }

    /**
     * Example query information about all administrator.
     *
     * @return
     */
    public List<Manager> listManagers() {
        return MANAGER_DAO.selectAllManagers();
    }

    /**
     * Save administrator
     *
     * @param manager
     * @param roleId
     * @return
     */
    public boolean saveManager(Manager manager, int roleId) {
        //md5 encryption
        manager.setLoginPwd(MD5Utils.md5Encode(manager.getLoginPwd()));

        //save administrator information
        int i = MANAGER_DAO.insertManager(manager);

        //Save association.
        int j = MANAGER_DAO.insertMgrAndRole(manager.getMgrId(), roleId);

        return i > 0 && j > 0;
    }

    public boolean deleteManager(String mgrId) {
        //1.Example Delete the association between an administrator and a role.
        int i = MANAGER_DAO.deleteMgrAndRole(mgrId);
        //2.Example Delete administrator information.
        int j = MANAGER_DAO.deleteManager(mgrId);
        return j > 0 && i > 0;
    }

    /**
     * Query the administrator information based on the administrator id.
     *
     * @param mgrId
     * @return
     */
    public Manager getManagerById(String mgrId) {
        return MANAGER_DAO.selectManagerById(mgrId);
    }

    /**
     * Modifying administrator information.
     * @param manager
     * @param roleId
     * @return
     */
    public boolean updateManager(Manager manager, int roleId) {
        //Modify administrator.
        if (manager.getLoginPwd() == null || "".equals(manager.getLoginPwd())) {
            //Set the original password to manager.
            Manager oldManager = MANAGER_DAO.selectManagerById(manager.getMgrId());
            manager.setLoginPwd(oldManager.getLoginPwd());
        } else {
            String s = MD5Utils.md5Encode(manager.getLoginPwd());
            manager.setLoginPwd(s);
        }
        //Perform modification.
        int i = MANAGER_DAO.updateManager(manager);
        int j = 0;
        int k = 0;
        //Changing an administrator role;
        if (i > 0) {
            //Example Delete the original role relationship.
            j = MANAGER_DAO.deleteMgrAndRole(manager.getMgrId());
            //Add new association.
            k = MANAGER_DAO.insertMgrAndRole(manager.getMgrId(), roleId);
        }
        return i > 0 && j > 0 && k > 0;
    }
}
