package com.greyhat.workoshop.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.greyhat.workoshop.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	
}
