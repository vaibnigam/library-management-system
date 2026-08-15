package com.library.model;

public class Book {
	private String id;
	private String title;
	private String author;
	private int totalCopies;
	private int availableCopies;

	public Book(String id, String title, String author, int totalCopies, int availableCopies) {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setAvailableCopies(availableCopies);
		setTotalCopies(totalCopies);
	}

	@Override
	public String toString() {
		return "Book{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", author='" + author + '\''
				+ ", totalCopies=" + totalCopies + ", availableCopies=" + availableCopies + '}';
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setTotalCopies(int num) {
		this.totalCopies = num;
	}

	public void setAvailableCopies(int num) {
		this.availableCopies = num;
	}

	public int getTotalCopies() {
		return this.totalCopies;
	}

	public int getAvailableCopies() {
		return this.availableCopies;
	}
}
