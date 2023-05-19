package com.socialmedia.demo.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Entity(name="user_details")

//@Table   // with this table annotation we can also create table directly from here instead of using a schema.sql file
		// so currently we have two tables in our h2 database!

// update we deleted our schema.sql file and will be working with table created from here only

public class User {
	
	
	protected User() {} 
	@Id
	@GeneratedValue  //to generate automatically
	private Integer id;
	
	@Size(min=2, message="Name should have atleast 2 characters")
//	@Column			
//	@JsonProperty("user_name") -> you can use this annotation to explicitly rename json attribute (property), when displayed in JSON
	private String name;
	
	@Past(message="BirthDate should be in past")
//	@Column
	private LocalDate birthdate;
	
	//maintaining the cardinality of our table!
	@OneToMany(mappedBy="user")
	@JsonIgnore //-> we dont want posts for user in json notations
	private List<Post> posts;
	
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthdate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthdate = birthDate;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthdate + "]";
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
