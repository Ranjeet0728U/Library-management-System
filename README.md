# Library Management

A simple Java console application for managing a small library. The app can load book details from text files, add new books, and display all books in the library.

## Project Structure

- `Admin/main.java` - application entry point and menu interface
- `Admin/Management.java` - core library management logic
- `Classes/Book.java` - book data model
- `FolderName/AuthorName.txt` - stored author names
- `FolderName/BookName.txt` - stored book titles
- `FolderName/Number.txt` - stored quantity values
- `FolderName/PublishYear.txt` - stored publication years

## Features

- Load books from existing files
- Add new books to the library
- Display all loaded books

## Prerequisites

- Java JDK installed (Java 8 or newer)

## Run Instructions

1. Open a terminal in the project root directory.
2. Compile the Java classes:

```powershell
javac -d out Admin\main.java Admin\Management.java Classes\Book.java
```

3. Run the application:

```powershell
java -cp out Admin.main
```

## Notes

- The app reads and writes book data from files under `FolderName/`.
- When adding a book, the details are appended to the files and also stored in memory.
- If the files do not exist, create them first with the names shown above.
