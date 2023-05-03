package com.capitalease.financemainster.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitalease.financemainster.model.Client;

@Repository
public interface UserRepository extends JpaRepository<Client, Long> {

	public List<Client> findByNameContainingIgnoreCase(String name);

}
