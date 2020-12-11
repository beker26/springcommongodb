package com.example.demo.controller;




import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.util.URL;
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


	@Override
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}


	@Override
	public ResponseEntity<List<Post>> fullsearch(String text, String minDate, String maxDate) {
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(minDate, new Date());
		List<Post> list = postService.fullSearch(text,min,max);
		return ResponseEntity.ok().body(list);
	}
	

	
	
	

}
