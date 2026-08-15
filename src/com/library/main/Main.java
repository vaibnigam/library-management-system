package com.library.main;

import java.util.Scanner;

import com.library.model.Book;
import com.library.service.LibraryService;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryService libraryService = new LibraryService();
        boolean running = true;

        while (running) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Search Book by ID");
            System.out.println("4. View All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer clear karne ke liye, taaki agla nextLine() sahi kaam kare

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

                    libraryService.addBook(id, title, author, copies);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundByTitle = libraryService.searchByTitle(searchTitle);
                    System.out.println(foundByTitle != null ? foundByTitle : "Book not found.");
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