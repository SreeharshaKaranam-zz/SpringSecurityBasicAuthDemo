package com.wordpress.sreeharsha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.wordpress.sreeharsha.model.ApartmentMember;

@Transactional
public interface ApartmentMemberRepository extends MongoRepository<ApartmentMember, String>{

}
