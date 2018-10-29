package org.webshop.springmvcsecurity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webshop.springmvcsecurity.authentication.MyDBAuthenticationService;
import org.webshop.springmvcsecurity.model.LoginUser;
import org.webshop.springmvcsecurity.token.JwtTokenUtil;
import org.webshop.springmvcsecurity.token.JwtUser;

@CrossOrigin(origins = {"http://localhost:4200"})

@RequestMapping(value = "/auth")
@RestController
public class LoginAuthenticationController {
	
	@Value("${jwt.header}")
	private String tokenHeader;

	@SuppressWarnings("unused")
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	MyDBAuthenticationService userDetailsService;
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public  JwtUser getAuthenticatedUser(HttpServletRequest request , @RequestBody LoginUser loginUser) {
		System.out.println("auth");
        String token = request.getHeader(tokenHeader);
        String username1 = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username1);
        return user;
    }

}
