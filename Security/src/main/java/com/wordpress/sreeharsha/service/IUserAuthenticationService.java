package com.wordpress.sreeharsha.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserAuthenticationService extends UserDetailsService {
	

	/**
	 * Method to authenticate a user 
	 */
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


}
