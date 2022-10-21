package com.ssantos.api.services;

import java.util.List;

import com.ssantos.api.domain.Users;

public interface UserService {

	Users findById(Integer id);

	List<Users> findAll();
}
