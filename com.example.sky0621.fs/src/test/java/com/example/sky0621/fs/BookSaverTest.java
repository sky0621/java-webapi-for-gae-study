package com.example.sky0621.fs;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookSaverTest {

    @Test
    public void CRUDのテスト() {
        List<String> authors = new ArrayList<>();
        authors.add("青山 真也");
        BookSaver.add(new Book("B07HFS7TDT", "Kubernetes完全ガイド", authors, 4104));

        Assert.assertEquals(1, BookSaver.list().size());
        Book one = BookSaver.get("B07HFS7TDT");
        Assert.assertEquals("Kubernetes完全ガイド", one.getBookName());

        Book edit = new Book("B07HFS7TDT", "aiueo", authors, 1000);
        BookSaver.update(edit);
        Book one2 = BookSaver.get("B07HFS7TDT");
        Assert.assertEquals("aiueo", one2.getBookName());

        BookSaver.delete("B07HFS7TDT");
        Assert.assertEquals(0, BookSaver.list().size());
    }

}
