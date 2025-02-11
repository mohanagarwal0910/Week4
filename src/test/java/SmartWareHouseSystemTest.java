package com.capgeminitrainingday1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SmartWareHouseSystemTest {

    @Test
    void testElectronicsCreation() {
        Electronics laptop = new Electronics("Laptop", "Dell");
        assertEquals("Laptop", laptop.getName());
    }

    @Test
    void testGroceriesCreation() {
        Groceries milk = new Groceries("Milk", "2025-01-01");
        assertEquals("Milk", milk.getName());
    }

    @Test
    void testFurnitureCreation() {
        Furniture chair = new Furniture("Chair", "Wood");
        assertEquals("Chair", chair.getName());
    }

    @Test
    void testStorageFunctionality() {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Electronics laptop = new Electronics("Laptop", "Dell");
        electronicsStorage.addItem(laptop);

        List<Electronics> items = electronicsStorage.getItems();
        assertEquals(1, items.size());
        assertEquals("Laptop", items.get(0).getName());
    }

}
