package com.example.sky0621.fs;

import java.util.List;

public class Book {
    private String asin;
    private String bookName;
    private List<String> authors;
    private int price;

    public Book() {
    }

    public Book(String asin, String bookName, List<String> authors, int price) {
        this.asin = asin;
        this.bookName = bookName;
        this.authors = authors;
        this.price = price;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
