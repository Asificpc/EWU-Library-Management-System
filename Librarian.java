package LMC;

import java.util.InputMismatchException;
import java.util.Scanner;

class Librarian extends User {
    public Librarian(String username, String password, String name) {
        super(username, password, name);
    }

    @Override
    public void showMenu(Scanner scanner, Library library) {
        int option;
        do {
            System.out.println("\n--- Librarian Menu ---");
            System.out.println("1. Add Book\n2. Remove Book\n3. View All Books\n4. Search Book\n0. Logout");
            option = readOption(scanner, 0, 4);

            switch (option) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine().trim();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine().trim();
                    try {
                        library.addBook(new Book(title, author, isbn));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Enter ISBN to remove: ");
                    try {
                        library.removeBook(scanner.nextLine().trim());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> library.viewAllBooks();
                case 4 -> {
                    System.out.print("Enter keyword to search: ");
                    library.searchBook(scanner.nextLine().trim());
                }
                case 0 -> System.out.println("Logged out successfully.");
            }
        } while (option != 0);
    }

    private int readOption(Scanner scanner, int min, int max) {
        while (true) {
            try {
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();
                if (option >= min && option <= max) return option;
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println("Invalid input! Please enter a number between " + min + " and " + max + ".");
        }
    }
}
