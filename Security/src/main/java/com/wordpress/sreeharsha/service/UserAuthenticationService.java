package com.wordpress.sreeharsha.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.wordpress.sreeharsha.model.ApplicationUser;
import com.wordpress.sreeharsha.repository.IUserRepository;

@Component
public class UserAuthenticationService implements IUserAuthenticationService {

	private static final Logger LOG = Logger.getLogger(UserAuthenticationService.class);
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		org.springframework.security.core.userdetails.User userDetail = null;
		ApplicationUser user = null;
		try{
			LOG.debug("Username :: " + username);
			user = userRepository.findUserByUsername(username);
		} catch (DataAccessException ex) {
			LOG.error("DataAccessException :: " + ex);
			LOG.error("Invalid login, user logged in :" + username );
	        throw new UsernameNotFoundException("Invalid login", ex);
	    }
	    if (user == null) {
	    	LOG.error("Called username : "+username + " - user not found.");
	        throw new UsernameNotFoundException("ApplicationUser not found.");
		} else {
			LOG.info("Called username : " + username);
			userDetail = new org.springframework.security.core.userdetails.User(username , user.getPassword(), this.getSecurityAuthorities(user.getRole()));
		}
		return userDetail;
	}
	
	private List<GrantedAuthority> getSecurityAuthorities(String role) {
		List<GrantedAuthority> authList = new ArrayList<>();
		if ("ADMIN".equalsIgnoreCase(role)) {
			authList.add(new SimpleGrantedAuthority("ADMIN"));
		} else if ("USER".equalsIgnoreCase(role)) {
			authList.add(new SimpleGrantedAuthority("USER"));
		}
		return authList;
	}
}