package com.socialmedia.demo.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.socialmedia.demo.JPApackage.postRepository;
import com.socialmedia.demo.JPApackage.userRepository;

import jakarta.validation.Valid;

@RestController
public class UserJPAResource {
	
	private userRepository repository;	
	
	private postRepository postRepo;
	
	public UserJPAResource(userRepository repository, postRepository postRepo) {		
		this.repository = repository;
		this.postRepo = postRepo;
	}
	
	
	//GET all user details
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	
	
	// GET single user details
	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id){		
		Optional<User> user= repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("user not found "+ " id:"+id);
		}
		else return user;
	}
	
	//POST (Insert) a user
	@PostMapping("/jpa/users")					// @Valid automatically starts validations after we have created them in beans
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {  //this User object from user will be mapped to User bean
			
		repository.save(user);
		// simple return a status code of created-> 201	
	//	return ResponseEntity.created(null).build();
		
		//return the URI of the newly created entry along with 201 status code
		User savedUser = repository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){		
		repository.deleteById(id);			
	}
	
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllPostsForUser(@PathVariable int id){
		Optional<User> user= repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("user not found "+ " id:"+id);
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> retrieveAllPostsForUser(@PathVariable int id, @Valid @RequestBody Post post){
		Optional<User> user= repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("user not found "+ " id:"+id);
		}
		post.setUser(user.get());
		
		//  postRepo.save(post);
		
		Post savedPost = postRepo.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
