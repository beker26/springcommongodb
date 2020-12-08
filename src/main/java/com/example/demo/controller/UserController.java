package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController implements UserApi {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ResponseEntity<List<UserDto>> findAll() {
    
		List<User> list = this.userService.FindAll();
		List<UserDto> listDto = list.stream().map(u -> new UserDto(u)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}

	@Override
	public ResponseEntity<UserDto> findById(@PathVariable String id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(new UserDto(user));
	}

	@Override
	public ResponseEntity<Void> insert(UserDto objDto) {
	    User user = userService.fromDTO(objDto);
	    user = userService.insert(user);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Override
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Void> update(UserDto objDto, String id) {
		User user = userService.fromDTO(objDto);
		user.setId(id);
		user = userService.update(user);
		return ResponseEntity.noContent().build();
	}

	
	
	

}
