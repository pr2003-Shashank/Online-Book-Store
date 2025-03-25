package com.training.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bookstore.entity.Book;
import com.training.bookstore.exception.BookNotFoundException;
import com.training.bookstore.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor-based dependency injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Add a new book
    public Book addBook(Book book) {
        if (book.getTitle() == null || book.getAuthor() == null || book.getPrice() == null) {
            throw new IllegalArgumentException("Book title, author, and price cannot be null");
        }
        return bookRepository.save(book);
    }

    // Retrieve all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Retrieve a book by ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));
    }

    // Update an existing book
    public Book updateBook(Long id, Book updatedBook) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Cannot update. Book with ID " + id + " not found.");
        }
        updatedBook.setId(id); // Ensure the same ID is used
        return bookRepository.save(updatedBook);
    }

    // Delete a book by its ID
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Cannot delete. Book with ID " + id + " not found.");
        }
        bookRepository.deleteById(id);
    }
}
