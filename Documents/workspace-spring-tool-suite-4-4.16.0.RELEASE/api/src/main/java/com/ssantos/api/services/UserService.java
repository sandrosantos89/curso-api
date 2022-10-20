package com.ssantos.api.services;

import com.ssantos.api.domain.User;

public interface UserService {

	User findById(Integer id);
}
