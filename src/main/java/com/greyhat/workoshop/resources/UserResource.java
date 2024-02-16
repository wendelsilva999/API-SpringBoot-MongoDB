package com.greyhat.workoshop.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greyhat.workoshop.domain.User;
import com.greyhat.workoshop.dto.UserDTO;
import com.greyhat.workoshop.services.UserService;

@RestController
@RequestMapping(value="user")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//@GetMapping(value="/users")
	@GetMapping(value="/all")
	public ResponseEntity<List<UserDTO>> findAll (){
		
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
}
