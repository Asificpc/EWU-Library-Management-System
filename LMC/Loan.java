package LMC;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Loan {
    private static final int LOAN_PERIOD_DAYS = 7;
    private static final int FINE_PER_DAY = 1;

    private final Book book;
    private final Member member;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(LOAN_PERIOD_DAYS);
    }

    public void returnBook() {
        if (returnDate != null) return;
        returnDate = LocalDate.now();
        book.returned();
        int fine = calculateFine();
        System.out.println("Returned on: " + returnDate);
        System.out.println(fine > 0 ? "Late return! Fine: $" + fine : "Returned on time. No fine.");
    }

    public int calculateFine() {
        if (returnDate == null || !returnDate.isAfter(dueDate)) return 0;
        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        return (int) daysLate * FINE_PER_DAY;
    }

    public Book getBook() { return book; }
    public LocalDate getReturnDate() { return returnDate; }
    public LocalDate getDueDate() { return dueDate; }

    @Override
    public String toString() {
        return book.getDetails() + " | Borrowed: " + borrowDate + " | Due: " + dueDate + " | Returned: " + returnDate;
    }
}
