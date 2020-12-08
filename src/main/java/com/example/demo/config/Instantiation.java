package com.example.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.CommentDto;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	private UserRepository userRepository;
	private PostRepository postRepository;

	public Instantiation(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;

	}

	@Override
	public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		this.userRepository.deleteAll();
		this.postRepository.deleteAll();

		User lucas = new User(null, "Luquinhas", "luquinhas@gmail.com");
		User paulo = new User(null, "Paleto", "paleto@gmail.com");
		User kaio = new User(null, "Kaioba", "kaioba@gmail.com");
		this.userRepository.saveAll(Arrays.asList(lucas, paulo, kaio));
		
		Post post1 = new Post(null, sdf.parse("21/03/2020"), "partiu viagem", "vou viajar para são paulo. abraços", new AuthorDto(lucas));
        Post post2 = new Post(null, sdf.parse("21/03/2020"), "bom dia ", "acordei feliz hoje", new AuthorDto(lucas));

        CommentDto c1 = new CommentDto("Boa viagem mano!", sdf.parse("13/02/2018"), new AuthorDto(paulo));
        CommentDto c2 = new CommentDto("Aproveire", sdf.parse("13/02/2018"), new AuthorDto(lucas));
        CommentDto c3 = new CommentDto("Tanha um ótimo dia", sdf.parse("13/02/2018"), new AuthorDto(kaio));
        
        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));
        
		this.postRepository.saveAll(Arrays.asList(post1,post2));
		
		lucas.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(lucas);
	}

}
