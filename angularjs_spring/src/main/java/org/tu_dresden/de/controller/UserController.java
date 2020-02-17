package org.tu_dresden.de.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tu_dresden.de.internal.app.repositories.UserRepository;
import org.tu_dresden.de.internal.entities.User;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return(List<User>) userRepository.findAll(); //find all users
	}
	
	@GetMapping("/users")
	public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
}
