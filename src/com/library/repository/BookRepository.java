package com.library.repository;

import com.library.model.Book;

public class BookRepository {
	private Book[] books = new Book[100];
	private int count;

//	void addBook(String id, String title, String author, int totalCopies, int availableCopies) {
	public void addBook(Book book) {
		if (count >= this.books.length) {
			System.out.println("Library is full");
			return;
		}
		this.books[count++] = book;
	}

	public Book findById(String id) {
		for (int i = 0; i < count; i++) {
			if (books[i] != null && books[i].getId().equals(id)) {
				return books[i];
			}
		}
		System.out.println("Book Not Found");
		return null;

	}

	public Book findByTitle(String title) {
		for (int i = 0; i < count; i++) {
			if (books[i] != null && books[i].getTitle().equals(title)) {
				return books[i];
			}
		}
		System.out.println("Book not found");
		return null;

	}
	
	public Book[] getAllBooks() {
		Book[] allBooks = new Book[count];
		for(int i =0;i<count;i++) {
			allBooks[i]=books[i];
		}
		return allBooks;
	}
}
