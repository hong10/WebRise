package com.hong.day06.domain;

/**
 * Created by hong on 2016/5/17.
 */
public class Book {

    private String name;
    private String author;
    private float price;
    private String description;

    public Book(String name, String author, float price, String description) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
