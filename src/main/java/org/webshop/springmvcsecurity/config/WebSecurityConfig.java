package org.webshop.springmvcsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.webshop.springmvcsecurity.authentication.MyDBAuthenticationService;
import org.webshop.springmvcsecurity.token.JwtAuthenticationEntryPoint;
import org.webshop.springmvcsecurity.token.JwtAuthenticationFilter;
import org.webshop.springmvcsecurity.token.JwtTokenUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration
// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    
    @Autowired
    
    MyDBAuthenticationService myDBAauthenticationService;
 
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
 
        // For User in database.
        auth.userDetailsService(this.myDBAauthenticationService);
        //.passwordEncoder(passwordEncoder());
        
        
    }
    
    @Bean
    public  PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
    
    @Bean
    public  JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
        
        //.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and().
       // sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

       // .authorizeRequests();
        
        
 
        // The pages does not require login
        /*.antMatchers("/", "/welcome", "/login", "/logout", "/origins/restmain/**", "/login/authenticate", "/auth/user/**").permitAll();
 
        // /userInfo page requires login as USER or ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
 
        // For ADMIN only.
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/search/**").access("hasAnyRole('ROLE_SEARCH','ROLE_ADMIN')")
        .antMatchers("/multifilesave/**").access("hasAnyRole('ROLE_SEARCH','ROLE_ADMIN')")
        .antMatchers("/initMultiFile/**").access("hasAnyRole('ROLE_SEARCH','ROLE_ADMIN')")
        .antMatchers("/restmain/**").access("hasAnyRole('ROLE_SEARCH','ROLE_ADMIN')");*/
       // .antMatchers("/origins/restmain/**").access("hasAnyRole('ROLE_SEARCH','ROLE_ADMIN')")
        //anyRequest().authenticated();

        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will throw.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // Config for Login Form
        
        http.authorizeRequests().antMatchers("/", "/welcome", "/login", "/logout", "/origins/restmain/**", "/login/authenticate", "/auth/user/**").permitAll();
        
        // /userInfo page requires login as USER or ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
 
        // For ADMIN only.
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/search/**").access("hasAnyRole('ROLE_SEARCH','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/multifilesave/**").access("hasAnyRole('ROLE_SEARCH','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/initMultiFile/**").access("hasAnyRole('ROLE_SEARCH','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/restmain/**").access("hasAnyRole('ROLE_SEARCH','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/restcostomer/**").access("hasAnyRole('ROLE_SEARCH','ROLE_ADMIN')");
 
        
        http.authorizeRequests().and().formLogin()
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/userInfo")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").clearAuthentication(true).logoutSuccessUrl("/").invalidateHttpSession(true) ;
 
    }

}
