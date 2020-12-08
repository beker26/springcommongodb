package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;

@RestController
@RequestMapping(value = "/users")
public interface UserApi {
    
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll();
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id);
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDto objDto);
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id);
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDto objDto, @PathVariable String id);
}
