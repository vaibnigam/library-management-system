package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;

public class LibraryService {

    private BookRepository bookRepository;

    public LibraryService() {
        this.bookRepository = new BookRepository();
    }

    public void addBook(String id, String title, String author, int copies) {
        Book existingBook = bookRepository.findById(id);

        if (existingBook != null) {
            existingBook.setTotalCopies(existingBook.getTotalCopies() + copies);
            existingBook.setAvailableCopies(existingBook.getAvailableCopies() + copies);
        } else {
            Book newBook = new Book(id, title, author, copies, copies);
            bookRepository.addBook(newBook);
        }
    }

    public Book searchByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book searchById(String id) {
        return bookRepository.findById(id);
    }

    public void viewAllBooks() {
        Book[] allBooks = bookRepository.getAllBooks();
        for (Book b : allBooks) {
            System.out.println(b);
        }
    }
}