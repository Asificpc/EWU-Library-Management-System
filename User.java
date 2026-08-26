package LMC;

import java.util.Scanner;

abstract class User {
    private final String username;
    private final String password;
    private final String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getUsername() { return username; }
    public String getName() { return name; }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public abstract void showMenu(Scanner scanner, Library library);
}
