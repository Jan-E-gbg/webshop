package org.webshop.springmvcsecurity.dao;

import java.util.List;

import org.webshop.springmvcsecurity.model.Customber;
import org.webshop.springmvcsecurity.model.UserInfo;

public interface UserInfoDAO {
	
	public UserInfo findUserInfo(String userName);
    
    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);
    
    public Customber getCostobmerObj(String  userName);
     

}
