package org.webshop.springmvcmultids.routing;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
 
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        
        if(request == null){
        	
        	System.out.println("request is null");
        }
    
        String keyDS = (String) request.getAttribute("keyDS");
        
        System.out.println("KeyDS=" + keyDS);
        
        if(keyDS == null){
        	
        	keyDS = "LOGIN_DS";
        }
        
        return keyDS;
    }
}
