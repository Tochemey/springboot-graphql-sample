package com.tutorials.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorials.graphql.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
