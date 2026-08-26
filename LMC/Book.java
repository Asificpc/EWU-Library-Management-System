package LMC;

class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private boolean borrowed;

    public Book(String title, String author, String isbn) {
        if (title == null || title.isBlank() || author == null || author.isBlank() || isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("Title, author and ISBN cannot be empty.");
        }
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return borrowed; }

    public void borrow() { borrowed = true; }
    public void returned() { borrowed = false; }

    public String getDetails() {
        return "Title: " + title + " | Author: " + author + " | ISBN: " + isbn + " | Status: " + (borrowed ? "Borrowed" : "Available");
    }
}
