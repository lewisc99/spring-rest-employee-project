package com.lewis.springrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.springrest.entity.AuthenticationRequest;
import com.lewis.springrest.entity.AuthenticationResponse;
import com.lewis.springrest.services.MyUserDetailsService;
import com.lewis.springrest.util.JwtUtil;

@RestController
@RequestMapping()
public class DemoRestController {

	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello -  world";
	}
	
	

	@PostMapping(value="/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody
			AuthenticationRequest authenticationRequest) throws Exception
	{
		
		
		try 
		{
			authenticationManager.authenticate(
					
					new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			
			
			
		}
		//if not authenticate throw an exception
		catch(BadCredentialsException e)
		{
			throw new Exception("Incorrect username or password ", e);
		}
		
		
		//get user
		final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());
		
		
		//generate token
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		
		//return AuthenticateResponse is a model to the token
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
		
		
	}
	
	
}
