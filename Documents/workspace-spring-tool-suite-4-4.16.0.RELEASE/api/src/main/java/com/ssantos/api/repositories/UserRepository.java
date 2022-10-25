package com.ssantos.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssantos.api.domain.Users;

@Repository
public interface UserRepository  extends JpaRepository<Users, Integer>{

	Optional<Users> findByEmail(String email);

}
