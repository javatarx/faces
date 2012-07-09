package accounts.internal.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import accounts.User;

import java.util.List;

public interface UserDao  {

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	public List<User> getUsers();
	public User saveUser(User user);
	public String getUserPassword(String username);
	public User getUser(Long id);
    
}
