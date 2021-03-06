package com.example.demo.controller;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Post;


@RestController
@RequestMapping(value = "/posts")
public interface PostApi {
    

	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id);
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text);
	@GetMapping(value="/fullsearch")
	public ResponseEntity<List<Post>> fullsearch(@RequestParam(value="text", defaultValue="") String text
			,@RequestParam(value="minDate", defaultValue="") String minDate
			,@RequestParam(value="maxDate", defaultValue="") String maxDate);
}
