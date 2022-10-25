package com.ssantos.api.services;

import java.util.List;

import com.ssantos.api.domain.Users;
import com.ssantos.api.domain.dto.UserDTO;

public interface UserService {

	Users findById(Integer id);
	List<Users> findAll();
	Users create(UserDTO obj);
}
