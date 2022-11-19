package com.company.joblistings.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.company.joblistings.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
