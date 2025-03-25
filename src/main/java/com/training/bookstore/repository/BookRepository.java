package com.training.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	// JpaRepository provides built-in CRUD operations
}
