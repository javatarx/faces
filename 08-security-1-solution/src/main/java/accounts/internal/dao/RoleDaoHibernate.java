package accounts.internal.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import accounts.Role;

import java.util.List;

@Repository("roleDao")
public class RoleDaoHibernate extends HibernateDaoSupport implements RoleDao {

	@Autowired
    public RoleDaoHibernate(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @SuppressWarnings("rawtypes")
	public Role getRoleByName(String rolename) {
        List roles = getHibernateTemplate().find("from Role where name=?", rolename);
        if (roles.isEmpty()) {
            return null;
        } else {
            return (Role) roles.get(0);
        }
    }

    public void removeRole(String rolename) {
        Object role = getRoleByName(rolename);
        getHibernateTemplate().delete(role);
    }
    
    public List<Role> getRoles(){
    	return getHibernateTemplate().loadAll(Role.class);
    }
}
