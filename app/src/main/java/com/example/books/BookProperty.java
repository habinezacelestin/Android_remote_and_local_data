package com.example.books;

public class BookProperty {
    private String book_name;
    private String author;
    private String pages;
    private int option;

    public BookProperty(String book_name, String author, String pages) {
        this.book_name = book_name;
        this.author = author;
        this.pages = pages;

    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
}


