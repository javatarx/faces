package accounts.internal.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import accounts.User;

import javax.persistence.Table;
import java.util.List;

@Repository("userDao")
public class UserDaoHibernate extends HibernateDaoSupport implements UserDao, UserDetailsService {

    /**
     * Constructor that sets the entity to User.class.
     */
	@Autowired
    public UserDaoHibernate(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return getHibernateTemplate().find("from User u order by upper(u.username)");
    }

    /**
     * {@inheritDoc}
     */
    public User saveUser(User user) {
        getHibernateTemplate().saveOrUpdate(user);
        getHibernateTemplate().flush();
        return user;
    }

    public void save(User user) {
        getHibernateTemplate().saveOrUpdate(user);        
    }

    /** 
     * {@inheritDoc}
    */
    @SuppressWarnings("rawtypes")
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List users = getHibernateTemplate().find("from User where username=?", username);
        if (users == null || users.isEmpty()) {
            throw new UsernameNotFoundException("user '" + username + "' not found...");
        } else {
            return (UserDetails) users.get(0);
        }
    }

    /** 
     * {@inheritDoc}
    */
    public String getUserPassword(String username) {
        SimpleJdbcTemplate jdbcTemplate =
                new SimpleJdbcTemplate(SessionFactoryUtils.getDataSource(getSessionFactory()));
        Table table = AnnotationUtils.findAnnotation(User.class, Table.class);
        return jdbcTemplate.queryForObject(
                "select password from " + table.name() + " where username=?", String.class, username);

    }

	public User getUser(Long id) {
		return getHibernateTemplate().get(User.class, id);
	}
    
}
