package com.socialmedia.demo.JPApackage;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.demo.user.User;

public interface userRepository extends JpaRepository<User,Integer> {

}
