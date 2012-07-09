package accounts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import accounts.User;
import accounts.internal.service.UserManager;

@Component("userList")
@Scope("request")
public class UserList {

	@Autowired
	private UserManager userManager;
	
	public List<User> getUsers(){
        List<User> users = userManager.getUsers();
        return users;
	}
	
}
