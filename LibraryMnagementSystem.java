import java.util.Scanner;

public class LibraryMnagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Add some initial books to the library


        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to search (leave blank to view all books): ");
                    String searchTitle = scanner.nextLine();
                    if (!searchTitle.isEmpty()) {
                        Book searchedBook = library.findBookByTitle(searchTitle);
                        if (searchedBook != null) {
                            System.out.println("Searched book:");
                            System.out.println(searchedBook);
                        } else {
                            System.out.println("Book not found.");
                        }
                    }
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    System.out.println("Book added successfully.");
                    break;
                case 3:
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    if (library.borrowBook(borrowTitle)) {
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book not available or not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the title of the book you want to return: ");
                    String returnTitle = scanner.nextLine();
                    if (library.returnBook(returnTitle)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
