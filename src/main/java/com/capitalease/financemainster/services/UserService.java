package com.capitalease.financemainster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitalease.financemainster.model.Client;
import com.capitalease.financemainster.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	// Insert new user in database with instance of Client.
	public void insert(Client user) {
		userRepository.save(user);
	}

	// Find user or users for name.
	public List<Client> findByName(String name) {
		return userRepository.findByNameContainingIgnoreCase(name);
	}

	// Find user with Primary Key (ID)
	public Optional<Client> findClientById(Long id) {
		Optional<Client> user = userRepository.findById(id);
		return user;
	}

	// Find all users
	public List<Client> findAllClients() {
		return userRepository.findAll();
	}

	// Delete user with instance of Client.
	public void deleteClient(Client user) {
		userRepository.delete(user);
	}

	// Delete user with Primary Key (ID)
	public void deleteClientById(Long id) {
		userRepository.deleteById(id);
	}
}
