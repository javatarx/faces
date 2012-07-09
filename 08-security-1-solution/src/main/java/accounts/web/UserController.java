package accounts.web;


import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import accounts.User;

@Component("user")
@Scope("session")
public class UserController {
	
   private User currentUser = null;

    public User getCurrentUser(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	currentUser =  (User) auth.getPrincipal();	
        return currentUser;
    }
    
    

}
