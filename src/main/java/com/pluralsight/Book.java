package com.pluralsight;

public class Book {

    private int id;
    private String isbn;
    private String borrower;
    private String title;
    private boolean checkedOut;


    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.checkedOut = false;
        this.borrower = "";
    }

    public void checkOut(String name) {
        this.checkedOut = true;
        this.borrower = name;
    }
    public void checkIn() {
        this.checkedOut = false;
        this.borrower = "";
    }

    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isCheckedOut() { return checkedOut; }
    public String getBorrower() { return borrower; }









}
