package org.webshop.springmvcsecurity.config;

import java.nio.charset.Charset;
import java.util.List;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.webshop.springmvcmultids.interceptor.DataSourcentercetor;


public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
		
		@Bean
		public StandardServletMultipartResolver multipartResolver() {
			return new StandardServletMultipartResolver();
		}
	
		private static final Charset UTF8 = Charset.forName("UTF-8");
	 
	   // Config UTF-8 Encoding.
		
		/*@Override
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	       StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
	       stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
	       converters.add(stringConverter);
	 
	       // Add other converters ...
	   }*/
	 
	   // Static Resource Config
	   // equivalents for <mvc:resources/> tags
		
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**");
		}
		
	   @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	       registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
	       registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
	       registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
	   }
	 
	   // Equivalent for <mvc:default-servlet-handler/> tag
	   @Override
	   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	       configurer.enable();
	   }
	   
	   	   
	   //
	   @Override
	    public void addInterceptors(InterceptorRegistry registry) { 
	        registry.addInterceptor(new DataSourcentercetor())
	        .addPathPatterns("/login/**", "/search/**", "/multifilesave/**", "/restmain/**","/origins/restmain/**");
	        //** matches zero or more 'directories' in a path
	    }
	   
	 
	
}
