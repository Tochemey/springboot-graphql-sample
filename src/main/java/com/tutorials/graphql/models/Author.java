package com.tutorials.graphql.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author extends Audit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2280251350086103788L;

	@Id
	@GeneratedValue(generator = "author_generator")
	@SequenceGenerator(name = "author_generator", sequenceName = "author_sequence", initialValue = 1)
	private Long id;

	@Column(name = "first_name", nullable = false)
	@NotEmpty(message = "first name is required.")
	private String firstName;

	@Column(name = "last_name", nullable = false)
	@NotEmpty(message = "last name is required.")
	private String lastName;
	
	public Author(Long id) {
		this.id = id;
	}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
