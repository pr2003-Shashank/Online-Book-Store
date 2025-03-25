package com.training.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bookstore.entity.Book;
import com.training.bookstore.service.BookService;

@RestController
@RequestMapping("/books") // Base URL for all endpoints
public class BookController {

	private BookService bookService;
	
    // Constructor-based dependency injection
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
    // Endpoint to add a new book
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	// Endpoint to retrieve all books
	@GetMapping
	public List<Book> getAllBooks(){
		List<Book> books = bookService.getAllBooks();
		return books;
	}
	
    // Endpoint to retrieve a specific book by ID
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}
	
	// Endpoint to update an existing book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book) {
    	return bookService.updateBook(id, book);
    }
    
    // Endpoint to delete a book by ID
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
    	bookService.deleteBook(id);
    }

	
}
