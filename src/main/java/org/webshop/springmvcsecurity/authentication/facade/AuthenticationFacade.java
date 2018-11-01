package org.webshop.springmvcsecurity.authentication.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.webshop.springmvcsecurity.model.LoginUser;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

	
	public AuthenticationFacade() {
        super();
}
	
	private List<LoginUser> userCurrent = new ArrayList<LoginUser>();
	
	
	public final Authentication getAuthentication() {
		// TODO Auto-generated method stub
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public List<LoginUser> getAuthenticationUser(){
		
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		
		LoginUser current = new LoginUser();
		current.setUser(user.getName());
		userCurrent.add(current);
		
		return userCurrent;
	}

}
