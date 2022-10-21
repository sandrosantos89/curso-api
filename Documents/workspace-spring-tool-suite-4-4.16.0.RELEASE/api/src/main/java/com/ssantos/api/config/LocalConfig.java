package com.ssantos.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ssantos.api.domain.Users;
import com.ssantos.api.repositories.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {

	@Autowired
	private UserRepository repository;

	@Bean
	public void startDB() {
		Users u1 = new Users(null, "Sandro", "sandro@email.com", "1234");
		Users u2 = new Users(null, "Bianca", "bianca@email.com", "1234");

		repository.saveAll(List.of(u1, u2));
	}
}
