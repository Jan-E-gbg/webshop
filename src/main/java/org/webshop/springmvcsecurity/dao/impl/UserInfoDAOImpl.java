package org.webshop.springmvcsecurity.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webshop.springmvcsecurity.dao.UserInfoDAO;
import org.webshop.springmvcsecurity.mapper.CustomberRowMapper;
import org.webshop.springmvcsecurity.mapper.UserInfoMapper;
import org.webshop.springmvcsecurity.model.Customber;
import org.webshop.springmvcsecurity.model.UserInfo;

@Repository 
//@Transactional(readOnly=true)
public class UserInfoDAOImpl extends JdbcDaoSupport implements UserInfoDAO{
	
	

	//@Transactional("transactionManager1")
	@Autowired
    public UserInfoDAOImpl(Object  dataSource) {
        this.setDataSource((DataSource) dataSource);
    }
  
 
    @Override
    public UserInfo findUserInfo(String userName) {
        String sql = "Select u.username,u.password  from ushop u where u.username = ? ";
 
        Object[] params = new Object[] { userName };
        UserInfoMapper mapper = new UserInfoMapper();
        try {
            UserInfo userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
 
 
    @Override
    public List<String> getUserRoles(String userName) {
        String sql = "Select r.role from user_roles r where r.username = ? ";
         
        Object[] params = new Object[] { userName };
         
        List<String> roles = this.getJdbcTemplate().queryForList(sql,params, String.class);
         
        return roles;
    }


	public Customber getCostobmerObj(String userName) {
		// TODO Auto-generated method stub
		String sql = "Select worktable, cust_id from ushop where username = ? ";
		
		Object[] params = new Object[] { userName };
		
		Customber custobmer =  (Customber) this.getJdbcTemplate().queryForObject(sql,params, new CustomberRowMapper());
		
		
		return custobmer;
	}
    
	
}
