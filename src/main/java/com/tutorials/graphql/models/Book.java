package com.tutorials.graphql.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Book extends Audit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5790399725681530821L;
	
	@Id
	@GeneratedValue(generator = "book_generator")
	@SequenceGenerator(name = "book_generator", sequenceName = "book_sequence", initialValue = 1)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "isbn", nullable = false)
	private String isbn;
	
	@Column(name = "page_count")
	private int pageCount;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false, updatable = false)
	private Author author;
	
	public Book(String title, String isbn, int pageCount, Author author) {
		this.title = title;
		this.isbn = isbn;
		this.pageCount = pageCount;
		this.author = author;
	}
}

