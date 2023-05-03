package com.capitalease.financemainster.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capitalease.financemainster.model.Client;
import com.capitalease.financemainster.repositories.UserRepository;

import jakarta.validation.Valid;

@RequestMapping("api/client")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(path = "/create-alter", method = { RequestMethod.PUT, RequestMethod.POST })
	public @ResponseBody void createClient(@Valid Client user) {
		userRepository.save(user);
	}

	@GetMapping
	@RequestMapping("/find-id")
	public @ResponseBody Optional<Client> findClientById(@RequestParam(name = "id") Long id) {
		Optional<Client> user = userRepository.findById(id);
		return user;
	}

	@GetMapping
	@RequestMapping("/find-all")
	public @ResponseBody List<Client> findAllClients() {
		return userRepository.findAll();
	}

	@DeleteMapping
	@RequestMapping("/delete")
	public @ResponseBody void deleteClient(Client user) {
		userRepository.delete(user);
	}

	@DeleteMapping
	@RequestMapping("/delete-id")
	public @ResponseBody void deleteClientById(@RequestParam(name = "id") Long id) {
		userRepository.deleteById(id);
	}

	@GetMapping
	@RequestMapping("/find-name")
	public @ResponseBody List<Client> findByName(@RequestParam(name = "name") String name) {
		return userRepository.findByNameContainingIgnoreCase(name);
	}
}
