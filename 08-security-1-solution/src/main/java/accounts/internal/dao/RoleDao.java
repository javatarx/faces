package accounts.internal.dao;

import java.util.List;

import accounts.Role;

public interface RoleDao {

	public Role getRoleByName(String rolename);
    public void removeRole(String rolename);
    public List<Role> getRoles();
}
