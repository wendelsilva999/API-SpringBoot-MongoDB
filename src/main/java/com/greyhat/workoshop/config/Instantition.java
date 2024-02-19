package com.greyhat.workoshop.config;



import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.greyhat.workoshop.domain.Post;
import com.greyhat.workoshop.domain.User;
import com.greyhat.workoshop.dto.AuthorDTO;
import com.greyhat.workoshop.dto.CommentDTO;
import com.greyhat.workoshop.repository.PostRepository;
import com.greyhat.workoshop.repository.UserRepository;

@Configuration
public class Instantition implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "maria", "M@gmil.com");
		User joao = new User(null, "joao", "J@gmil.com");
		User alex = new User(null, "alex", "A@gmil.com");
		
		userRepository.saveAll(Arrays.asList(maria,joao,alex));
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"), "viajar carai", "vou pra gringa se fodam ai", new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("11/06/2018"), "sua mãe", "sua mãe e nossa", new AuthorDTO(alex));
		Post post3 = new Post(null,sdf.parse("07/10/2018"), "onlyfans", "abri onlyfans galeris", new AuthorDTO(joao));
		Post post4 = new Post(null,sdf.parse("15/11/2018"), "cana de cabeça", "ressaca da porra", new AuthorDTO(maria));
		
		
		CommentDTO c1 = new CommentDTO("vai viajar pro breu isso sim", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("tomara que o viajão caia", sdf.parse("22/03/2018"), new AuthorDTO(joao));
		CommentDTO c3 = new CommentDTO("amem", sdf.parse("22/03/2018"), new AuthorDTO(alex));
		CommentDTO c4 = new CommentDTO("tome duas aspirina que passa", sdf.parse("21/03/2018"), new AuthorDTO(joao));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post3.getComments().addAll(Arrays.asList(c3));
		post4.getComments().addAll(Arrays.asList(c4));
		
		postRepository.saveAll(Arrays.asList(post1,post2,post3,post4));
		
		maria.getPosts().addAll(Arrays.asList(post1,post4));
		userRepository.save(maria);
		
	}

}
