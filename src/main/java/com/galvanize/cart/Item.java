package com.galvanize.cart;

public class Item {
    public String name;
    public double price;
    public boolean isOnSale;

    public Item(String name, double price, boolean isOnSale){
        this.name = name;
        this.price = price;
        this.isOnSale = isOnSale;
    }
}
