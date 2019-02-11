package com.tutorials.graphql.resolvers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tutorials.graphql.errors.BookNotFoundException;
import com.tutorials.graphql.models.Author;
import com.tutorials.graphql.models.Book;
import com.tutorials.graphql.repositories.AuthorRepository;
import com.tutorials.graphql.repositories.BookRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	public Author newAuthor(String firstName, String lastName) {
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		return this.authorRepository.save(author);
	}

	@Transactional
	public Book newBook(String title, String isbn, Long pageCount, Long authorId) {
		Book book = new Book();
		book.setAuthor(new Author(authorId));
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setPageCount((int) (pageCount != null ? pageCount : 0));

		return this.bookRepository.save(book);
	}

	public Boolean deleteBook(Long id) {
		this.bookRepository.deleteById(id);
		return true;
	}

	public Book updateBookPageCount(Long pageCount, Long id) {
		Optional<Book> book = this.bookRepository.findById(id);
		if (book.isPresent()) {
			Book val = book.get();
			val.setPageCount(pageCount.intValue());
			this.bookRepository.save(val);
			return val;
		}
		throw new BookNotFoundException("The book to be updated was not found", id);

	}
}
