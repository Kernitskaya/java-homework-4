package ru.products.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean matches(String searchBy) {
        return super.matches(searchBy) || getAuthor().equalsIgnoreCase(searchBy);
    }
}
