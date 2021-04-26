package com.galvanize.cart;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cart {

    public ArrayList<Item> itemsList;

    public Cart() {
        this.itemsList = new ArrayList<>();
    }

    public void addToCart(Item item){
        this.itemsList.add(item);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item i : this.itemsList) {
            totalPrice += i.price;
        }
        return totalPrice;
    }

    public ArrayList<Item> itemizedList() {
        return this.itemsList;
    }

    public int itemQuantities(Item item) {
        int quantity = 0;

        for (Item i : this.itemsList) {
            if (i == item) {
                quantity++;
            }
        }

        return quantity;
    }

    public ArrayList<Item> onSaleItems() {
        ArrayList<Item> saleItems = new ArrayList<>();
        for (Item i : this.itemsList) {
            if(i.isOnSale){
                saleItems.add(i);
            }
        }
        return saleItems;
    }
}
