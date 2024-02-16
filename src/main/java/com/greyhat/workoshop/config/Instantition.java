package com.greyhat.workoshop.config;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.greyhat.workoshop.domain.User;
import com.greyhat.workoshop.repository.UserRepository;

@Configuration
public class Instantition implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User maria = new User(null, "maria", "M@gmil.com");
		User joao = new User(null, "joao", "J@gmil.com");
		User alex = new User(null, "alex", "A@gmil.com");
		
		//userRepository.save(Arrays.asList(maria, alex, joao));
		
		userRepository.saveAll(Arrays.asList(maria,joao,alex));
		
	}

}
