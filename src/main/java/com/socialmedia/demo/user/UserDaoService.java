package com.socialmedia.demo.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	
	// create all the CRUD methods that we want to implement using the REST api
	
	//for now we only create a static array list and use this DAO service class to talk to it.
	
	private static Integer usersCount=0;
	
	private static List<User> users= new ArrayList<>();
	
	static {
		users.add(new User(++usersCount,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"John",LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount,"Eve",LocalDate.now().minusYears(28)));
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		users.removeIf(predicate);		
	}
	
}
