package com.example.demo.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Post;


@RestController
@RequestMapping(value = "/posts")
public interface PostApi {
    

	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id);
	
}
