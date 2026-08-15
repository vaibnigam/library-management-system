package com.library.main;

import java.util.Scanner;

import com.library.model.Book;
import com.library.service.LibraryService;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LibraryService libraryService = new LibraryService();
		boolean running = true;

		// Program start hote hi sample data load karo
		libraryService.loadBooksFromFile("data/books.txt");

		while (running) {
			System.out.println("\n===== Library Management System =====");
			System.out.println("1. Add Book");
			System.out.println("2. Search Book by Title");
			System.out.println("3. Search Book by ID");
			System.out.println("4. View All Books");
			System.out.println("5. Remove Book");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter Book ID: ");
				String id = scanner.nextLine();

				System.out.print("Enter Title: ");
				String title = scanner.nextLine();

				System.out.print("Enter Author: ");
				String author = scanner.nextLine();

				System.out.print("Enter Copies: ");
				int copies = scanner.nextInt();
				scanner.nextLine();

				break;

			case 2:
				System.out.print("Enter Title to search: ");
				String searchTitle = scanner.nextLine();
				Book[] matches = libraryService.searchByTitle(searchTitle);
				if (matches.length == 0) {
					System.out.println("No books found.");
				} else {
					for (Book b : matches) {
						System.out.println(b);
					}
				}
				break;

			case 3:
				System.out.print("Enter ID to search: ");
				String searchId = scanner.nextLine();
				Book foundById = libraryService.searchById(searchId);
				System.out.println(foundById != null ? foundById : "Book not found.");
				break;

			case 4:
				libraryService.viewAllBooks();
				break;

			case 5:
				System.out.print("Enter Book ID to remove: ");
				String removeId = scanner.nextLine();
				boolean removed = libraryService.removeBook(removeId);
				System.out.println(removed ? "Book removed successfully!" : "Book not found.");
				break;

			case 6:
				running = false;
				System.out.println("Exiting... Goodbye!");
				break;

			default:
				System.out.println("Invalid choice, try again.");
			}
		}

		scanner.close();
	}
}