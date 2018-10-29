package org.webshop.springmvcmultids.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class DataSourcentercetor extends HandlerInterceptorAdapter  {
	
	private static final Logger log = LoggerFactory.getLogger(DataSourcentercetor.class);
	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		
		log.info("preHandleInfo");
		String contextPath = request.getServletContext().getContextPath();
		
		log.debug("[preHandle] " + contextPath);
		 
        // /SpringMVCMultiDS/login
        String prefixLogin = contextPath + "/login";
        
        // /SpringMVCMultiDS/search
        String prefixSearch = contextPath + "/search";
        
     // /SpringMVCMultiDS/search
        String prefixmultifilesave = contextPath + "/multifilesave";
        //MULTIFILE_DS
        
        ///restmain
        
        String prefixrestmain = contextPath + "/restmain";
        
		
        String uri = request.getRequestURI();
        System.out.println("URI:"+ uri);
        
        if(uri.startsWith(prefixLogin)) {
            request.setAttribute("keyDS", "LOGIN_DS");
        }
        
        else if(uri.startsWith(prefixSearch)) {
            request.setAttribute("keyDS", "SEARCH_DS");
        }
        
        else if(uri.startsWith(prefixmultifilesave)) {
        	request.setAttribute("keyDS", "MULTIFILE_DS");
        }
        else if(uri.startsWith(prefixrestmain)) {
        	request.setAttribute("kesDS", "RESTMAIN_DS");
        }
		
		
		return true;
	}
	

}
