package accounts.internal.service;

import java.util.List;

import accounts.Role;

public interface RoleManager {

	@SuppressWarnings("rawtypes")
	public List getRoles(Role role);
    public Role getRole(String rolename);
    public Role saveRole(Role role);
    public void removeRole(String rolename);
}
