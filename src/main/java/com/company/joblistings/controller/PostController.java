package com.company.joblistings.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.joblistings.Repository.PostRepository;
import com.company.joblistings.Repository.SearchRepository;
import com.company.joblistings.model.Post;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ayupant
 * @since 19-11-2022
 */
@RestController
public class PostController {

	@Autowired
	PostRepository repo;

	@Autowired
	SearchRepository searchRepo;

	@ApiIgnore
	@RequestMapping(value = "/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return repo.findAll();

	}

	@GetMapping("/posts/{text}")
	public List<Post> searchPost(@PathVariable String text) {
		return searchRepo.findByText(text);

	}

	@PostMapping("/add-post")
	public Post addPost(@RequestBody Post post) {
		return repo.save(post);

	}

}
