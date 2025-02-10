package com.capgeminitrainingday1;
import java.util.ArrayList;
import java.util.List;
abstract class WarehouseItem {
    private String name;
    public WarehouseItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract void displayDetails();
}
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics: " + getName() + ", Brand: " + brand);
    }
}

// Groceries category
class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, String expiryDate) {
        super(name);
        this.expiryDate = expiryDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Groceries: " + getName() + ", Expiry Date: " + expiryDate);
    }
}

// Furniture category
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture: " + getName() + ", Material: " + material);
    }
}

// Generic Storage class to store warehouse items
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }

    public void displayItems() {
        for (T item : items) {
            item.displayDetails();
        }
    }
}
class WarehouseUtility {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}
public class SmartWarehouseSystem {
    public static void main(String[] args) {
        // Creating storage for different types of items
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Adding items
        electronicsStorage.addItem(new Electronics("Laptop", "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", "Samsung"));

        groceriesStorage.addItem(new Groceries("Milk", "2025-03-01"));
        groceriesStorage.addItem(new Groceries("Rice", "2026-01-15"));

        furnitureStorage.addItem(new Furniture("Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", "Metal"));

        // Display individual storage items
        System.out.println("Electronics Storage:");
        electronicsStorage.displayItems();

        System.out.println("\nGroceries Storage:");
        groceriesStorage.displayItems();

        System.out.println("\nFurniture Storage:");
        furnitureStorage.displayItems();
        System.out.println("\nDisplaying all items from different storages:");
        WarehouseUtility.displayAllItems(electronicsStorage.getItems());
        WarehouseUtility.displayAllItems(groceriesStorage.getItems());
        WarehouseUtility.displayAllItems(furnitureStorage.getItems());
    }
}

