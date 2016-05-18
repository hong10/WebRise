package com.hong.day06.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hong on 2016/5/17.
 */
public class BookDB {
    private static Map<String, Book> books = new HashMap<String ,Book>();
    static{
        books.put("1", new Book("黄金时代", "王小波", 28.00f, "上山下乡"));
        books.put("2", new Book("白银时代", "陈清扬", 100.00f, "上山下乡"));
        books.put("3", new Book("青铜时代", "孔维西", 26.00f, "上山下乡"));
        books.put("4", new Book("黑铁时代", "何金晶", 83.00f, "上山下乡"));

    }

    public static Map<String, Book> findAllBooks(){
        return books;
    }

    public static Book findBookByName(String name) {
        return books.get(name);
    }

}
