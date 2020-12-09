package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public List<Post> FindAll() {
		return postRepository.findAll();

	}
	
	public Post findById(String id) {
		
		Post user = postRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
		return user;
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}
	

	
}
