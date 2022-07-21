package com.lewis.springrest.securities;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lewis.springrest.services.MyUserDetailsService;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled= true, securedEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	
	@Autowired 
	private JwtRequestFilter jwtRequestFilter;
	
	
	//will query the user in the database. gonna call the myUserDetailsService, where we implement a fake user foo.
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		
		try {
			auth.userDetailsService(myUserDetailsService);
		}
	catch (UsernameNotFoundException e)
		{
			throw new UsernameNotFoundException("User not found " + myUserDetailsService);
		}
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		//disable csrf cross-site request.
		//permits only /authenticate, any requests must be authenticated.
		
		
		
				
		
		http.csrf().disable()
			.authorizeRequests().antMatchers("/authenticate").permitAll()
			.anyRequest().authenticated()
			.and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS) //saying to spring to not  create a session.
			.and().exceptionHandling()
			.authenticationEntryPoint(
					(request,response,ex) -> {
						response.sendError(
								HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
					});
			
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
	
			
	}
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder  psswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}



}
