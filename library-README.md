# Library Management System

A console-based Library Management System built in core Java, following a layered architecture with clear separation between presentation, business logic, and data access.

## Overview

This application allows a librarian to manage a book catalog — adding books, searching by title/author/ID, removing books, and loading bulk data from a file. It is built entirely with core Java (no frameworks, no database), using arrays for in-memory storage.

## Architecture

The project follows a 4-layer design:

```
Main (Presentation) → LibraryService (Business Logic) → BookRepository (Data Layer) → Book (Model)
```

- **Model** — `Book`: represents a single book with its id, title, author, and copy counts.
- **Repository** — `BookRepository`: handles low-level storage operations (add, find, remove) using a fixed-size array.
- **Service** — `LibraryService`: contains business rules (e.g. preventing duplicate book entries by incrementing copy counts instead) and coordinates calls to the repository.
- **Main** — the console entry point; displays the menu, collects user input, and delegates all operations to `LibraryService`.

## Features

- Add a book (automatically merges copies if the ID already exists)
- Search books by title (case-insensitive, partial match)
- Search a book by ID (exact match)
- View all books in the catalog
- Search books by author (case-insensitive, partial match)
- Remove a book
- Bulk-load books from a `.txt` file at startup

## Project Structure

```
src/
  com/library/model/       → Book.java
  com/library/repository/  → BookRepository.java
  com/library/service/     → LibraryService.java
  com/library/main/        → Main.java
data/
  books.txt                → sample data loaded at startup
```

## Data File Format

`data/books.txt` uses comma-separated values, one book per line:

```
id,title,author,copies
```

Example:
```
B1,The Immortals of Meluha,Amish Tripathi,6
B2,1984,George Orwell,4
```

## Tech Stack

- Java 17
- Core Java only — no external libraries, no frameworks
- Console-based I/O via `Scanner`

## Running the Project

1. Import the project into Eclipse (or any Java IDE).
2. Ensure `data/books.txt` exists in the project root.
3. Run `Main.java`.

## Design Notes

- Storage is array-based (`Book[]`), reflecting a deliberate constraint to practice core data structures before introducing the Collections framework.
- Business logic (e.g. duplicate detection) is intentionally kept in the service layer, not the repository, to keep storage operations decision-free and reusable.
