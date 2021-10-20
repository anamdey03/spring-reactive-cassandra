package com.spring.cassandra.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cassandra.api.model.User;
import com.spring.cassandra.api.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/GetUsers")
	public Flux<User> getUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/GetUsersByAge/{age}")
	public Flux<User> getUserByAge(@PathVariable int age) {
		return userRepository.findByAgeLessThan(age);
	}
	
	@GetMapping("/GetUserByAddress/{address}")
	public Mono<User> getUserByAddress(String address) {
		return userRepository.findByAddress(address);
	}
}
