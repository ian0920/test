package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User getUser(Integer id) {
		
		Optional<User> u = userRepo.findById(id);
		User user = u.get();
		
		return user;
	}
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	public void deleteUser(Integer id) {
		Optional<User> u = userRepo.findById(id);
		User user = u.orElseThrow(() -> new RuntimeException("no such user"));
		
		userRepo.delete(user);
	}

}
