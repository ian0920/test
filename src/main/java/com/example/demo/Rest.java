package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id) {
		
		User user = service.getUser(id);

		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User createdUser = service.createUser(user);
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(createdUser);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user){
		
		User updatedUser = service.updateUser(user);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser (@PathVariable Integer id){
		
		service.deleteUser(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}
	
	

}
