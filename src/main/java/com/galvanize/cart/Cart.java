package com.galvanize.cart;
import java.util.ArrayList;

public class Cart {

    public ArrayList<Item> itemizedList;

    public Cart() {
        this.itemizedList = new ArrayList<>();
    }

    public void addToCart(Item item){
        this.itemizedList.add(item);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item i : this.itemizedList) {
            totalPrice += i.price;
        }
        return totalPrice;
    }
}
