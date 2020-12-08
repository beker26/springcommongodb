package com.example.demo.controller;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController implements PostApi {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}


	@Override
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}

	

	
	
	

}
