package org.webshop.springmvcsecurity.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.webshop.hibernate.dao.CompanyHnDAO;
import org.webshop.hibernate.dao.impl.CompanyHnDAOImpl;
import org.webshop.search.dao.CollectionOfModelDAO;
import org.webshop.search.dao.CollectionSearchDAO;
import org.webshop.search.dao.DisplayScreenSizeDAO;
import org.webshop.search.dao.EquipmentTypeDAO;
import org.webshop.search.dao.SearchItemDAO;
import org.webshop.search.dao.impl.CollectionOfModelDAOImpl;
import org.webshop.search.dao.impl.CollectionSearchImpl;
import org.webshop.search.dao.impl.DisplayScreenSizeDAOImpl;
import org.webshop.search.dao.impl.EquipmentTypeDAOImpl;
import org.webshop.search.dao.impl.SearchItemDAOImpl;
import org.webshop.search.workspace.dao.ItemDAO;
import org.webshop.search.workspace.dao.impl.ItemDAOImpl;
import org.webshop.springmvcmultids.routing.RoutingDataSource;
import org.webshop.springmvcsecurity.dao.UserInfoDAO;
import org.webshop.springmvcsecurity.dao.impl.UserInfoDAOImpl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@Configuration
@ComponentScan("org.webshop.*")
@EnableWebMvc
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:datasouce-cfg.properties")

public class ApplicationContextConfig {
	
	
	@Autowired   
	private Environment env;

	
	
	@Bean
	public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new   ResourceBundleMessageSource();
        messageSource.setBasename("message");
        return messageSource;
	}
	
	
	
	@Bean(name = "viewResolver")
	  public InternalResourceViewResolver getViewResolver() {
	      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	      viewResolver.setPrefix("/WEB-INF/pages/");
	      viewResolver.setSuffix(".jsp");
	      return viewResolver;
	  }
	
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() throws SQLException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource2());
        sessionFactory.setPackagesToScan(new String[] { "org.webshop.search.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
	
	

	 
	// Returns Routing DataSource (MyRoutingDataSource)
    @Autowired
    @Bean(name = "dataSource")
    public DataSource getDataSource(DataSource dataSource1, DataSource dataSource2) {
 
        System.out.println("## Create DataSource from dataSource1 & dataSource2");
 
        RoutingDataSource dataSource = new RoutingDataSource();
 
        Map<Object, Object> dsMap = new HashMap<Object, Object>();
        dsMap.put("LOGIN_DS", dataSource1);
        dsMap.put("SEARCH_DS", dataSource2);
        dsMap.put("MULTIFILE_DS", dataSource2);
        dsMap.put("RESTMAIN_DS", dataSource2);
        dataSource.setTargetDataSources(dsMap);
        
        return dataSource;
    } 
	
	@Bean(name = "dataSource1")
	  public DataSource getDataSource1() throws SQLException {
		DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
	 
	      // See: datasouce-cfg.properties
	      dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
	      dataSource1.setUrl("jdbc:mysql://localhost:3306/userbase");
	      dataSource1.setUsername("root");
	      dataSource1.setPassword("mysql");
	 
	      System.out.println("## getDataSource: " + dataSource1);
	 
	      return dataSource1;
	  }
	  
	  @Bean(name = "dataSource2")
	  public DataSource getDataSource2() throws SQLException{
		  BasicDataSource dataSource = new BasicDataSource();
	 
	      // See: datasouce-cfg.properties
	      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	      dataSource.setUrl("jdbc:mysql://localhost:3306/lexicon");
	      dataSource.setUsername("root");
	      dataSource.setPassword("mysql");
	 
	      System.out.println("## getDataSource2: " + dataSource);
	      System.out.println("env  " + env.getProperty("ds.url"));
	 
	      return dataSource;
	  }
	   
	  // Transaction Manager
	  @Autowired
	  @Bean(name = "transactionManager")
	  public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
	        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
	 
	        txManager.setDataSource(dataSource);
	 
	        return txManager;
	  }
	  
	  @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }
	  
	  private Properties hibernateProperties() {
		  	Properties properties = new Properties();
	        properties.put("hibernate.dialect",    env.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
	        properties.put("hibernate.hbm2ddl.auto",env.getRequiredProperty("hibernate.hbm2ddl.auto"));
	       	     
		  return properties;
	  }
	  
	  @Bean
		public UserInfoDAO getUserInfoDAO() throws SQLException{
		  
		return new UserInfoDAOImpl(getDataSource1());
		  
	  }
	  
	  @Bean
		public UserInfoDAO QualiUserInfoDAO() throws SQLException{
		  
		return new UserInfoDAOImpl(getDataSource1());
		  
	  }
	  
	  @Bean
		public org.webshop.search.dao.CompanyDAO getCompanyDAO() throws SQLException {
			return new org.webshop.search.dao.impl.CompanyDAOImpl(getDataSource2());
		}
	  
	  @Bean
		public org.webshop.search.dao.CompanyDAO QualiCompanyDAO() throws SQLException {
			return new org.webshop.search.dao.impl.CompanyDAOImpl(getDataSource2());
		}
	  
	  @Bean
		public DisplayScreenSizeDAO QualiDisplayScreenSizeDAO()throws SQLException {
			return new DisplayScreenSizeDAOImpl(getDataSource2());
		  
	  }
	  
	  @Bean 
	  public EquipmentTypeDAO QualiEquipmentTypeDAO ()throws SQLException {
		  
		  return new EquipmentTypeDAOImpl(getDataSource2());
	  }
	  
	  @Bean 
	  public SearchItemDAO QualiSearchItemDAO ()throws SQLException {
		  
		  return new SearchItemDAOImpl(getDataSource2());
	  }
	  
	  @Bean
	  public CollectionSearchDAO QualiCollectionSearchDAO ()throws SQLException {
		  
		  return new CollectionSearchImpl(getDataSource2());
	  }
	  
	  @Bean
	  public CompanyHnDAO QualiCompanyHnDAO ()throws SQLException {
		  
		  return new CompanyHnDAOImpl();
	  }
	  
	 @SuppressWarnings("rawtypes")
	 @Bean
	  public ItemDAO QualiItemDAO ()throws SQLException {
		  return new ItemDAOImpl(getDataSource2());
	  }
	 
	 @Bean
	 public CollectionOfModelDAO QualiCollectionOfModelDAO ()throws SQLException {
		 
		 return new CollectionOfModelDAOImpl(getDataSource2());
	 }
	  
	  
	  
	

}
