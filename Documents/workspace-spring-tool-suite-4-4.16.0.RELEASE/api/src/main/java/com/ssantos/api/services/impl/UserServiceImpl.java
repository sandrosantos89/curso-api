package com.ssantos.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssantos.api.domain.Users;
import com.ssantos.api.repositories.UserRepository;
import com.ssantos.api.services.UserService;
import com.ssantos.api.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public Users findById(Integer id) {
		Optional<Users> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
