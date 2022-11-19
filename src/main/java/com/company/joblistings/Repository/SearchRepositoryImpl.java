package com.company.joblistings.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import com.company.joblistings.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class SearchRepositoryImpl implements SearchRepository {

	@Autowired
	MongoClient mongoClient;

	@Autowired
	MongoConverter mongoConverter;

	@Override
	public List<Post> findByText(String text) {

		List<Post> findByText = new ArrayList<>();

		MongoDatabase database = mongoClient.getDatabase("JobLists");
		MongoCollection<Document> collection = database.getCollection("JobPosts");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				new Document("$search",
						new Document("index", "default").append("text",
								new Document("query", text).append("path", "desc"))),
				new Document("$sort", new Document("exp", 1L)), new Document("$limit", 3L)));

		result.forEach(docs -> findByText.add(mongoConverter.read(Post.class, docs)));
		return findByText;

	}

}
