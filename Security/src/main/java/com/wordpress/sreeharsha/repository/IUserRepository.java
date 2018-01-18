package com.wordpress.sreeharsha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.wordpress.sreeharsha.model.ApplicationUser;


@Component
public interface IUserRepository extends MongoRepository<ApplicationUser, String> {
	
	public ApplicationUser findUserByUsername(String username);
}
