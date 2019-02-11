package com.tutorials.graphql.resolvers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tutorials.graphql.models.Author;
import com.tutorials.graphql.models.Book;
import com.tutorials.graphql.repositories.AuthorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookResolver implements GraphQLResolver<Book>{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Optional<Author> getAuthor(Book book) {
		return this.authorRepository.findById(book.getAuthor().getId());
	}
}
