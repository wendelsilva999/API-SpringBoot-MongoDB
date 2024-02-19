package com.greyhat.workoshop.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greyhat.workoshop.domain.Post;
import com.greyhat.workoshop.repository.PostRepository;
import com.greyhat.workoshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		if (obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return obj.get();
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchtTitle(text);
	}
		

}
