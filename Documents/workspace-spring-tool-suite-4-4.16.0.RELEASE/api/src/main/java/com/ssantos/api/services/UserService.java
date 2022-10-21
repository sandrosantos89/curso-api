package com.ssantos.api.services;

import com.ssantos.api.domain.Users;

public interface UserService {

	Users findById(Integer id);
}
