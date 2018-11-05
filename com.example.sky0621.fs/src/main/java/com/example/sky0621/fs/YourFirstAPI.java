package com.example.sky0621.fs;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;

import java.util.List;

/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/
@Api(name = "fs",
     version = "v1")
public class YourFirstAPI {
    @ApiMethod(name = "books", path = "books", httpMethod = ApiMethod.HttpMethod.POST)
    public void addBook(Book book) {
        BookSaver.add(book);
    }

    @ApiMethod(name = "books", path = "books/{asin}", httpMethod = ApiMethod.HttpMethod.GET)
    public Book getBook(@Named("asin") String asin) {
        return BookSaver.get(asin);
    }

    @ApiMethod(name = "books", path = "books", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Book> listBooks() {
        return BookSaver.list();
    }

    @ApiMethod(name = "books", path = "books/{asin}", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateBook(@Named("asin") String asin, Book book) {
        BookSaver.update(book);
    }

    @ApiMethod(name = "books", path = "books/{asin}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteBook(@Named("asin") String asin) {
        BookSaver.delete(asin);
    }
}
