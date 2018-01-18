package com.wordpress.sreeharsha.repository;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.wordpress.sreeharsha.model.ApplicationUser;


@Component
public abstract class UserRepositoryImpl implements IUserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;	
	
	@Override
	public ApplicationUser findUserByUsername(String username) {
		ApplicationUser user = mongoTemplate.findOne(
				new Query(Criteria.where("_id").regex(Pattern.compile("^" + username + "$", Pattern.CASE_INSENSITIVE))),
				ApplicationUser.class, "user");
		return user;
	}

}
