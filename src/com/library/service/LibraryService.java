package com.library.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    public void loadBooksFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            int loadedCount = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue; // khali line skip karo
                }

                String[] parts = line.split(",");

                if (parts.length != 4) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                String id = parts[0].trim();
                String title = parts[1].trim();
                String author = parts[2].trim();
                int copies = Integer.parseInt(parts[3].trim());

                addBook(id, title, author, copies);
                loadedCount++;
            }

            fileScanner.close();
            System.out.println("Books loaded successfully from file.");

        } catch (FileNotFoundException e) {
            System.out.println("Sample data file not found. Starting with empty library.");
        }
    }

    public Book[] searchByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book searchById(String id) {
        return bookRepository.findById(id);
    }

    public boolean removeBook(String id) {
        return bookRepository.removeBook(id);
    }

    public void viewAllBooks() {
        Book[] allBooks = bookRepository.getAllBooks();
        for (Book b : allBooks) {
            System.out.println(b);
        }
    }
}