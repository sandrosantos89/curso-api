package com.ssantos.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssantos.api.domain.Users;
import com.ssantos.api.domain.dto.UserDTO;
import com.ssantos.api.repositories.UserRepository;
import com.ssantos.api.services.UserService;
import com.ssantos.api.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Users findById(Integer id) {
		Optional<Users> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Users> findAll() {
		return repository.findAll();
	}

	//tranformando um UserDTO em User com mapper
	@Override
	public Users create(UserDTO obj) {
		return repository.save(mapper.map(obj, Users.class));
	}
}
