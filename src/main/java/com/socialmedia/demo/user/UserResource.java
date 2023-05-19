package com.socialmedia.demo.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service=service;
	}
	
	
	//GET all user details
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	
	// GET single user details
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){		
		User user= service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("user not found "+ " id:"+id);
		}
		else return user;
	}
	
	//POST (Insert) a user
	@PostMapping("/users")					// @Valid automatically starts validations after we have created them in beans
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {  //this User object from user will be mapped to User bean
			
		service.save(user);
		// simple return a status code of created-> 201	
	//	return ResponseEntity.created(null).build();
		
		//return the URI of the newly created entry along with 201 status code
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){		
		service.deleteById(id);			
	}
}
