package com.company.joblistings.Repository;

import java.util.List;

import com.company.joblistings.model.Post;

public interface SearchRepository {

	List<Post> findByText(String text);

}
