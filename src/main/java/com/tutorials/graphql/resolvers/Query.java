package com.tutorials.graphql.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tutorials.graphql.models.Author;
import com.tutorials.graphql.models.Book;
import com.tutorials.graphql.repositories.AuthorRepository;
import com.tutorials.graphql.repositories.BookRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Query implements GraphQLQueryResolver{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findAllBooks(){
		return this.bookRepository.findAll();
	}
	
	public List<Author> findAllAuthors(){
		return this.authorRepository.findAll();
	}
	
	public long countBooks() {
		return this.bookRepository.count();
	}
	
	public long countAuthors() {
		return this.authorRepository.count();
	}
}
