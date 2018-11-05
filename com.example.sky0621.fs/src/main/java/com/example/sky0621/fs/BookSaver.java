package com.example.sky0621.fs;

import java.util.ArrayList;
import java.util.List;

public class BookSaver {
    private static List<Book> bookList = new ArrayList<>();

    public static void add(Book book) {
        bookList.add(book);
    }

    public static Book get(String asin) {
        for (Book b : bookList) {
            if (b.getAsin().equals(asin)) {
                return b;
            }
        }
        return null;
    }

    public static List<Book> list() {
        return bookList;
    }

    public static void update(Book book) {
        List<Book> bl = new ArrayList<>();
        for (Book b : bookList) {
            if (b.getAsin().equals(book.getAsin())) {
                bl.add(book);
            } else {
                bl.add(b);
            }
        }
        bookList = bl;
    }

    public static void delete(String asin) {
        List<Book> bl = new ArrayList<>();
        for (Book b : bookList) {
            if (!b.getAsin().equals(asin)) {
                bl.add(b);
            }
        }
        bookList = bl;
    }
}
