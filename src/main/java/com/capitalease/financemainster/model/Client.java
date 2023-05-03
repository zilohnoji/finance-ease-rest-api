package com.capitalease.financemainster.model;

import java.io.Serializable;

import com.capitalease.financemainster.status.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "users")

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = false, length = 50)
	private String name;

	@Column(nullable = false, unique = true, length = 50)
	private String email;

	@Column(nullable = false, unique = false, length = 50)
	private String password;

	@Column(nullable = false, unique = true, length = 50)
	private String cpf;

	@Column(nullable = false, unique = false, length = 100)
	private String dateRegister;

	@Min(value = 10)
	@Column(nullable = false, unique = false, length = 3)
	private Integer age;

	@Column(nullable = false, unique = false)
	private Status status;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Client() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(String dateRegister) {
		this.dateRegister = dateRegister;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
