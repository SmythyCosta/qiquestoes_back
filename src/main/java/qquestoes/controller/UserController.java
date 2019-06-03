package qquestoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import qquestoes.model.User;
import qquestoes.repository.UserRepository;

@RestController
@RequestMapping(value="/api/users")
public class UserController {	
	
	private UserRepository repository;
	
	UserController(UserRepository userRepository) {
       this.repository = userRepository;
   }
	
	@GetMapping
	public List findAll(){
	   return repository.findAll();
	}	
	
	@PostMapping
	public User create(@RequestBody User user){
	   return user;
	}
		
	
}
