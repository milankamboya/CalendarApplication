package com.global.common.framework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
{
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
    private CustomUserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests().antMatchers("/welcome", "/showSignupPage").permitAll();
		http.addFilterBefore(new CustomSpringSecurityFilter(), BasicAuthenticationFilter.class)
			.authorizeRequests().antMatchers("/**").authenticated()
			.and().formLogin().loginPage("/login")
			.usernameParameter("userName").passwordParameter("password").permitAll()
			.successHandler(customAuthenticationSuccessHandler);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception 
	{
	    web.ignoring().antMatchers("/resources/**");
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService(userService);
        auth.authenticationProvider(authenticationProvider());
    }
	
    @Bean
    public CustomAuthenticationProvider authenticationProvider() throws Exception {
    	CustomAuthenticationProvider customAuthenticationProvider = new CustomAuthenticationProvider();
    	customAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    	customAuthenticationProvider.setUserDetailsService(userService);
        return customAuthenticationProvider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }
    
    /*@Bean
    public DaoAuthenticationProvider authenticationProvider() 
    {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }*/
}
