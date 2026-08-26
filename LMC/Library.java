package LMC;

import java.util.ArrayList;
import java.util.List;

class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addUser(User user) {
        if (user == null) throw new IllegalArgumentException("User cannot be null.");
        users.add(user);
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.login(username, password)) return user;
        }
        return null;
    }

    public void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null.");
        for (Book existing : books) {
            if (existing.getIsbn().equalsIgnoreCase(book.getIsbn())) {
                throw new IllegalArgumentException("A book with this ISBN already exists.");
            }
        }
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(String isbn) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("ISBN cannot be empty.");
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                if (book.isBorrowed()) throw new IllegalArgumentException("Cannot remove a borrowed book.");
                books.remove(book);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        throw new IllegalArgumentException("Book not found.");
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in library.");
            return;
        }
        for (Book book : books) System.out.println(book.getDetails());
    }

    public void searchBook(String keyword) { searchBook(keyword, true); }

    public void searchBook(String keyword, boolean showDetails) {
        if (keyword == null || keyword.isBlank()) {
            System.out.println("Search keyword cannot be empty.");
            return;
        }
        String search = keyword.toLowerCase();
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(search) || book.getAuthor().toLowerCase().contains(search) || book.getIsbn().toLowerCase().contains(search)) {
                System.out.println(showDetails ? book.getDetails() : book.getTitle());
                found = true;
            }
        }
        if (!found) System.out.println("No books found with the keyword.");
    }

    public Loan borrowBook(String isbn, Member member) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("ISBN cannot be empty.");
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                if (book.isBorrowed()) throw new IllegalArgumentException("Book is already borrowed.");
                book.borrow();
                Loan loan = new Loan(book, member);
                loans.add(loan);
                System.out.println("Book borrowed successfully.\nDue: " + loan.getDueDate());
                return loan;
            }
        }
        throw new IllegalArgumentException("Book not found.");
    }

    public void returnBook(Loan loan) {
        if (loan == null) throw new IllegalArgumentException("Loan cannot be null.");
        loan.returnBook();
    }
}
