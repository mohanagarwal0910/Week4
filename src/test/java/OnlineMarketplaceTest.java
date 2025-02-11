package com.capgeminitrainingday1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class OnlineMarketplaceTest {
    private ProductCatalog<Book> bookCatalog;
    private ProductCatalog<Clothing> clothingCatalog;
    private ProductCatalog<Gadget> gadgetCatalog;

    private Book book;
    private Clothing shirt;
    private Gadget phone;

    @BeforeEach
    void setUp() {
        bookCatalog = new ProductCatalog<>();
        clothingCatalog = new ProductCatalog<>();
        gadgetCatalog = new ProductCatalog<>();

        book = new Book("Java Programming", 50.0, "Science");
        shirt = new Clothing("T-Shirt", 20.0, "Men's Fashion");
        phone = new Gadget("Smartphone", 500.0, "Electronics");
    }

    @Test
    void testProductCreation() {
        assertEquals("Java Programming", book.getName());
        assertEquals(50.0, book.getPrice());
        assertEquals("Science", book.getCategory());

        assertEquals("T-Shirt", shirt.getName());
        assertEquals(20.0, shirt.getPrice());
        assertEquals("Men's Fashion", shirt.getCategory());

        assertEquals("Smartphone", phone.getName());
        assertEquals(500.0, phone.getPrice());
        assertEquals("Electronics", phone.getCategory());
    }

    @Test
    void testAddProductToCatalog() {
        bookCatalog.addProduct(book);
        clothingCatalog.addProduct(shirt);
        gadgetCatalog.addProduct(phone);

        assertEquals(1, bookCatalog.getProducts().size());
        assertEquals(1, clothingCatalog.getProducts().size());
        assertEquals(1, gadgetCatalog.getProducts().size());
    }

    @Test
    void testApplyDiscount() {
        ProductCatalog.applyDiscount(book, 10);
        ProductCatalog.applyDiscount(shirt, 15);
        ProductCatalog.applyDiscount(phone, 5);

        assertEquals(45.0, book.getPrice(), 0.01);
        assertEquals(17.0, shirt.getPrice(), 0.01);
        assertEquals(475.0, phone.getPrice(), 0.01);
    }
}
