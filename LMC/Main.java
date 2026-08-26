package LMC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        loadDefaultUsers(library);
        loadDefaultBooks(library);

        System.out.println("=================================");
        System.out.println("     EWU Library Management System");
        System.out.println("=================================");

        while (true) {
            System.out.print("\nUsername (or type 'exit' to quit): ");
            String username = scanner.nextLine().trim();
            if (username.equalsIgnoreCase("exit")) break;

            System.out.print("Password: ");
            String password = scanner.nextLine();

            User user = library.authenticate(username, password);
            if (user != null) {
                System.out.println("\nWelcome, " + user.getName() + "!");
                user.showMenu(scanner, library);
            } else {
                System.out.println("Invalid login credentials.");
            }
        }

        System.out.println("Thank you for using EWU Library Management System.");
        scanner.close();
    }

    private static void loadDefaultUsers(Library library) {
        library.addUser(new Librarian("Rafin", "Rafin123", "Rafin Murad"));
        library.addUser(new Member("Farzana", "Far", "Farzana Akter"));
        library.addUser(new Member("Salman", "123", "Salman Shajid"));
        library.addUser(new Member("Sadia", "123", "Sadia Afroz"));
        library.addUser(new Member("Asif", "123", "Asif Ali"));
    }

    private static void loadDefaultBooks(Library library) {
        library.addBook(new Book("Shei Shomoy", "Sunil Gangopadhyay", "9708"));
        library.addBook(new Book("Prothom Alo", "Sunil Gangopadhyay", "3031"));
        library.addBook(new Book("Jochona O Jononir Golpo", "Humayun Ahmed", "2767"));
        library.addBook(new Book("Deyal", "Humayun Ahmed", "1272"));
        library.addBook(new Book("Pather Panchali", "Bibhutibhushan Bandopadhyay", "2215"));
    }
}
