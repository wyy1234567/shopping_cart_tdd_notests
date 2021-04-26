package com.galvanize.cart;

public class Item {
    public double price;
    public boolean isOnSale;

    public Item(double price, boolean isOnSale){
        this.price = price;
        this.isOnSale = isOnSale;
    }

//    public Item(double price) {
//        this.price = price;
//        this.isOnSale = false;
//    }
}
