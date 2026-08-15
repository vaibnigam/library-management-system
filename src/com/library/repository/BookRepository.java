package com.library.repository;

import com.library.model.Book;

public class BookRepository {
	private Book[] books = new Book[100];
	private int count;

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
		return null;
	}

	public Book[] findByTitle(String title) {
		int matchCount = 0;
		for (int i = 0; i < count; i++) {
			if (books[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
				matchCount++;
			}
		}

		Book[] result = new Book[matchCount];
		int resultIndex = 0;
		for (int i = 0; i < count; i++) {
			if (books[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
				result[resultIndex++] = books[i];
			}
		}
		return result;
	}

	public boolean removeBook(String id) {
		int indexToRemove = -1;

		for (int i = 0; i < count; i++) {
			if (books[i] != null && books[i].getId().equals(id)) {
				indexToRemove = i;
				break;
			}
		}

		if (indexToRemove == -1) {
			return false;
		}

		for (int i = indexToRemove; i < count - 1; i++) {
			books[i] = books[i + 1];
		}

		books[count - 1] = null;
		count--;

		return true;
	}

	public Book[] getAllBooks() {
		Book[] allBooks = new Book[count];
		for (int i = 0; i < count; i++) {
			allBooks[i] = books[i];
		}
		return allBooks;
	}
}