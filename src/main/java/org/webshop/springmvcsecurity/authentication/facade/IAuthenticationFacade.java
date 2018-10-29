package org.webshop.springmvcsecurity.authentication.facade;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
	
	Authentication getAuthentication();

}
