package com.capitalease.financemainster.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capitalease.financemainster.model.Client;
import com.capitalease.financemainster.services.UserService;

import jakarta.validation.Valid;

@RequestMapping("api/client")
@RestController
public class UserResource {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/create-alter", method = { RequestMethod.PUT, RequestMethod.POST })
	public @ResponseBody void createClient(@Valid @RequestBody Client user) {
		userService.insert(user);
	}

	@GetMapping
	@RequestMapping("/find-id")
	public @ResponseBody Optional<Client> findClientById(@RequestParam(name = "id") Long id) {
		Optional<Client> user = userService.findClientById(id);
		return user;
	}

	@GetMapping
	@RequestMapping("/find-name")
	public @ResponseBody List<Client> findByName(@RequestParam(name = "name") String name) {
		return userService.findByName(name);
	}

	@GetMapping
	@RequestMapping("/find-all")
	public @ResponseBody List<Client> findAllClients() {
		return userService.findAllClients();
	}

	@DeleteMapping
	@RequestMapping("/delete")
	public @ResponseBody void deleteClient(@RequestBody Client user) {
		userService.deleteClient(user);
	}

	@DeleteMapping
	@RequestMapping("/delete-id")
	public @ResponseBody void deleteClientById(@RequestParam(name = "id") Long id) {
		userService.deleteClientById(id);
	}

}
