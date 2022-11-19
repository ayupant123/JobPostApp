package com.company.joblistings.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "JobPosts")
@Data
public class Post {

	private String profile;
	private String desc;
	private float exp;
	private List<String> technologies;

	public Post() {
		super();
	}

	public Post(String profile, String desc, float exp, List<String> technologies) {
		super();
		this.profile = profile;
		this.desc = desc;
		this.exp = exp;
		this.technologies = technologies;
	}

}
