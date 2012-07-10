package accounts.internal.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import accounts.User;

import java.util.List;

public interface UserManager {
	
    public User getUser(String userId);
    public User getUserByUsername(String username) throws UsernameNotFoundException;
    public List<User> getUsers();
    public User saveUser(User user) throws UserExistsException ;
    public void removeUser(String userId);
    public List<User> search(String searchTerm);
}
