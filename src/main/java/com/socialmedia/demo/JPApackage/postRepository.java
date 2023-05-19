package com.socialmedia.demo.JPApackage;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.demo.user.Post;

public interface postRepository extends JpaRepository<Post,Integer> {
	
}
