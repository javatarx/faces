package accounts.internal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accounts.Role;
import accounts.internal.dao.RoleDao;

import java.util.List;

/**
 * Implementation of RoleManager interface.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
@Service("roleManager")
public class RoleManagerImpl implements RoleManager {
	
    RoleDao roleDao;

    @Autowired
    public RoleManagerImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> getRoles(Role role) {
        return roleDao.getRoles();
    }

    public Role getRole(String rolename) {
        return roleDao.getRoleByName(rolename);
    }
    
    public Role saveRole(Role role) {
        return null;
    }

    public void removeRole(String rolename) {
        roleDao.removeRole(rolename);
    }
}