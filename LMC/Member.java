package LMC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Member extends User {
    private final List<Loan> loans = new ArrayList<>();

    public Member(String username, String password, String name) {
        super(username, password, name);
    }

    @Override
    public void showMenu(Scanner scanner, Library library) {
        int option;
        do {
            System.out.println("\n--- Member Menu ---");
            System.out.println("1. Borrow Book\n2. Return Book\n3. View My Books\n4. Search Book\n5. Check Fines\n0. Logout");
            option = readOption(scanner, 0, 5);

            switch (option) {
                case 1 -> {
                    System.out.print("Enter ISBN to borrow: ");
                    try {
                        Loan loan = library.borrowBook(scanner.nextLine().trim(), this);
                        loans.add(loan);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> returnBook(scanner, library);
                case 3 -> viewMyBooks();
                case 4 -> {
                    System.out.print("Enter keyword to search: ");
                    library.searchBook(scanner.nextLine().trim(), true);
                }
                case 5 -> checkFines();
                case 0 -> System.out.println("Logged out successfully.");
            }
        } while (option != 0);
    }

    private void returnBook(Scanner scanner, Library library) {
        System.out.print("Enter ISBN to return: ");
        String isbn = scanner.nextLine().trim();
        for (Loan loan : loans) {
            if (loan.getBook().getIsbn().equalsIgnoreCase(isbn) && loan.getReturnDate() == null) {
                library.returnBook(loan);
                return;
            }
        }
        System.out.println("Invalid ISBN or book already returned.");
    }

    private void viewMyBooks() {
        boolean activeLoan = false;
        for (Loan loan : loans) {
            if (loan.getReturnDate() == null) {
                System.out.println(loan);
                activeLoan = true;
            }
        }
        if (!activeLoan) System.out.println("You have no currently borrowed books.");
    }

    private void checkFines() {
        int totalFine = 0;
        for (Loan loan : loans) totalFine += loan.calculateFine();
        System.out.println(totalFine == 0 ? "You have no fines." : "Your total fine is: $" + totalFine);
    }

    private int readOption(Scanner scanner, int min, int max) {
        while (true) {
            try {
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();
                if (option >= min && option <= max) return option;
            } catch (Exception e) {
                scanner.nextLine();
            }
            System.out.println("Invalid input! Please enter a number between " + min + " and " + max + ".");
        }
    }
}
