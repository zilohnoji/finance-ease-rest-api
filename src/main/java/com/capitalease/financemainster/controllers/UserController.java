package com.capitalease.financemainster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capitalease.financemainster.model.Client;
import com.capitalease.financemainster.repositories.UserRepository;

import jakarta.validation.Valid;

@RequestMapping("api/clients")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	@RequestMapping("/create")
	public @ResponseBody void createClient(@Valid Client user) {
		userRepository.save(user);
	}

}
