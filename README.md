# EWU Library Management System

A Java-based console application for managing library books, members, borrowing, returning, searching, and fines.

## Project Overview

The **EWU Library Management System** is designed to provide basic library management functionalities through a simple console-based interface.

The system supports two types of users:

* **Librarian**
* **Member**

## Features

### Librarian

* Add new books
* Remove books
* View all books
* Search for books
* Logout

### Member

* Borrow books
* Return books
* View borrowed books
* Search for books
* Check fines
* Logout

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Java Collections (`ArrayList`, `List`)
* Java Date and Time API (`LocalDate`, `Period`)
* Console-based user interface

## OOP Concepts Used

This project demonstrates several important Object-Oriented Programming concepts:

* **Encapsulation** — private attributes with public methods
* **Inheritance** — `Librarian` and `Member` inherit from `User`
* **Abstraction** — `User` is an abstract class
* **Polymorphism** — `showMenu()` is overridden by different user types
* **Method Overloading** — `searchBook()` has multiple versions

## Project Structure

```text
EWU-Library-Management-System
│
├── LMC
│   ├── Book.java
│   ├── Library.java
│   ├── Librarian.java
│   ├── Loan.java
│   ├── Main.java
│   ├── Member.java
│   └── User.java
│
└── README.md
```

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/YOUR-USERNAME/EWU-Library-Management-System.git
```

### 2. Open the project

Open the project in any Java IDE such as:

* IntelliJ IDEA
* Eclipse
* NetBeans
* VS Code

### 3. Run the program

Run:

```text
LMC/Main.java
```

## Default Login Information

### Librarian

```text
Username: Rafin
Password: Rafin123
```

### Members

```text
Username: Farzana
Password: Far

Username: Salman
Password: 123

Username: Sadia
Password: 123

Username: Asif
Password: 123
```

## Default Books

The system initially contains several books, including:

* Shei Shomoy — Sunil Gangopadhyay
* Prothom Alo — Sunil Gangopadhyay
* Jochona O Jononir Golpo — Humayun Ahmed
* Deyal — Humayun Ahmed
* Pather Panchali — Bibhutibhushan Bandopadhyay

## Borrowing and Fine System

* A borrowed book has a **7-day due period**.
* The system records the borrowing and return dates.
* A fine is calculated when a book is returned after the due date.

## Author

**EWU Library Management System**

Developed as a Java Object-Oriented Programming project.

