package org.example;

public class Item {
    private String name;
    private String category;
    private float price;

    public Item(String name, String category, float price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Item(String name, float price) {
        this(name, "Generic Category", price);
    }

    public Item(float price) {
        this("Generic Item", "Generic Category", price);
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + category + ": " + price;
    }
}
