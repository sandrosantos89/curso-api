package com.ssantos.api.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ssantos.api.domain.Users;
import com.ssantos.api.domain.dto.UserDTO;
import com.ssantos.api.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private static final String ID = "/{id}";

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserService service;

	@GetMapping(value = ID)
	public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok()
				.body(service.findAll().stream().map(x -> mapper.map(x, UserDTO.class)).collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO obj) {
		Users newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID).buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = ID)
	public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO obj) {
		obj.setId(id);
		Users newObj = service.update(obj);
		return ResponseEntity.ok().body(mapper.map(newObj, UserDTO.class));

	}

	@DeleteMapping(value = ID)
	public ResponseEntity<UserDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
