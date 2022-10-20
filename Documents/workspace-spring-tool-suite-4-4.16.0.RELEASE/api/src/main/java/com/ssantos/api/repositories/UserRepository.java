package com.ssantos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssantos.api.domain.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

}
