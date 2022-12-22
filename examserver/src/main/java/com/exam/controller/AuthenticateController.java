package com.exam.controller;

import com.exam.config.JwtUtils;
import com.exam.model.JWTRequest;
import com.exam.model.JWTResponse;
import com.exam.model.User;
import com.exam.services.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController
{
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtUtils jwtUtils;

	//generate token

	@PostMapping("/generate-token")
	public ResponseEntity<?> generatetoken(@RequestBody JWTRequest jwtRequest) throws Exception
	{
		try
		{

			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

		}
		catch (Exception e)
		{
			throw new Exception("user not found");
		}

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JWTResponse(token));
	}


	private void authenticate(String username,String password) throws Exception
	{
		try{

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

		}catch (DisabledException e){
			throw new Exception("user disabled" + e.getMessage());
		}catch (BadCredentialsException e){
			throw new Exception("invalid credential" + e.getMessage());
		}
	}
}
