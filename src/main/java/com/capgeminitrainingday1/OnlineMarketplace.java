package com.capgeminitrainingday1;

import java.util.ArrayList;
import java.util.List;

// Enum for Book Categories
enum BookCategory {
    FICTION, NON_FICTION, EDUCATIONAL
}

// Enum for Clothing Categories
enum ClothingCategory {
    MENS_WEAR, WOMENS_WEAR, KIDS_WEAR
}

// Enum for Gadget Categories
enum GadgetCategory {
    MOBILE, LAPTOP, ACCESSORY
}

// Generic Product Class
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}

// Generic method to apply discount
class DiscountManager {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
    }
}

// Main class
public class OnlineMarketplace {
    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("Java Programming", 500, BookCategory.EDUCATIONAL);
        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 800, ClothingCategory.MENS_WEAR);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15000, GadgetCategory.MOBILE);

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        System.out.println("Before Discount:");
        catalog.forEach(System.out::println);

        // Apply discount
        DiscountManager.applyDiscount(book, 10);
        DiscountManager.applyDiscount(shirt, 15);
        DiscountManager.applyDiscount(phone, 5);

        System.out.println("\nAfter Discount:");
        catalog.forEach(System.out::println);
    }
}

