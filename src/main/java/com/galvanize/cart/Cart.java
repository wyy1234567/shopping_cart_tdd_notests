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

    public String getTotalPrice() {
        double totalPrice = 0;
        String res = "";
        int quantity = 0;
        for (Item i : this.itemsList) {
            totalPrice += i.price;
            quantity++;
        }
        res = quantity + " item, total price: $" + totalPrice;
        return res;
    }

    public ArrayList<String> itemizedList() {
        ArrayList<String> result = new ArrayList<>();

        for (Item  i : this.itemsList) {
            String info = "";
            info = i.name + ": $" + i.price;
            result.add(info);
        }

        return result;
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
