package com.galvanize.cart;

import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @Test
    public void createEmptyCart() {

        Cart cart = new Cart();
        ArrayList<Item> expected = new ArrayList<>();
        ArrayList<Item> actual = cart.itemsList;
        assertIterableEquals(expected, actual, "Initialize with an empty cart");
    }


    @Test
    public void addItemToCart() {
        Item item = new Item("Ribs",10, false);
        Cart cart = new Cart();

        cart.addToCart(item);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item);
        ArrayList<Item> actual = cart.itemsList;
        assertIterableEquals(expected, actual, "Able to add an item to the cart");

    }


    @Test
    public void itemizedListSingleItem(){
        Cart cart = new Cart();
//        Item item = new Item(200, false);
        Item item = new Item("Apple", 2.5, false);

        cart.addToCart(item);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Apple: $2.5");
        ArrayList<String> actual = cart.itemizedList();

        assertEquals(expected, actual, "Should return item name and price for single item in the cart");
    }

    @Test
    public void itemizedListMultipleItems(){
        Cart cart = new Cart();
        Item item = new Item("Apple", 2.5, false);
        cart.addToCart(item);

        Item item1 = new Item("Coffee", 3.5, false);
        cart.addToCart(item1);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Apple: $2.5");
        expected.add("Coffee: $3.5");

        ArrayList<String> actual = cart.itemizedList();

        assertEquals(expected, actual, "itemizedList should return string list if having multiple items");
    }

    @Test
    public void getTotalPrice() {
        Cart cart = new Cart();

        Item item = new Item("Ice cream",12.13, false);
        cart.addToCart(item);

        Item item1 = new Item("Slow cooker",20.99, false);
        cart.addToCart(item1);

        String expected = "2 item, total price: $33.12";
        String actual = cart.getTotalPrice();

        assertEquals(expected, actual, "Cart knowing total price and quantity of items in it");
    }

    @Test
    public void itemQuantities(){
        Cart cart = new Cart();
        Item item = new Item("Bag",100, false);
        cart.addToCart(item);

        int expected = 1;
        int actual = cart.itemQuantities(item);

        assertEquals(expected, actual, "itemQuantities should return the quantity of an item placed in the cart");
    }

    @Test
    public void itemQuantitiesOfThree(){
        Cart cart = new Cart();
        Item item = new Item("Bag",100, false);
        cart.addToCart(item);
        cart.addToCart(item);
        cart.addToCart(item);

        int expected = 3;
        int actual = cart.itemQuantities(item);

        assertEquals(expected, actual, "itemQuantities should return the quantity of an item placed in the cart");
    }

    @Test
    public void variedQuantities(){
        Cart cart = new Cart();
        Item item1 = new Item("Bag",100, false);
        Item item2 = new Item("Flower",30, false);
        cart.addToCart(item1);
        cart.addToCart(item1);
        cart.addToCart(item2);

        int expected = 2;
        int actual = cart.itemQuantities(item1);

        assertEquals(expected, actual, "itemQuantities should return the quantity of an item placed in the cart");
    }

    @Test
    public void onSaleItems(){
        Cart cart = new Cart();
        Item item1 = new Item("Headphones",80.0, true);
        Item item2 = new Item("Iphone",600, false);

        cart.addToCart(item1);
        cart.addToCart(item2);

        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);

        ArrayList<Item> actual = cart.onSaleItems();

        assertIterableEquals(expected, actual, "Should return a list of items on sale");
    }

    @Test
    public void onSaleMultipleItems(){
        Cart cart = new Cart();
        Item item1 = new Item("Sofa",800.0, true);
        Item item2 = new Item("Table",6000, false);

        cart.addToCart(item1);
        cart.addToCart(item1);
        cart.addToCart(item1);
        cart.addToCart(item2);

        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item1);
        expected.add(item1);

        ArrayList<Item> actual = cart.onSaleItems();

        assertIterableEquals(expected, actual, "Should return a list of items on sale");
    }


    @Test
    public void onSaleNoItems(){
        Cart cart = new Cart();
        Item item1 = new Item("Sofa",800.0, false);
        Item item2 = new Item("Table",6000, false);

        cart.addToCart(item1);
        cart.addToCart(item2);

        ArrayList<Item> expected = new ArrayList<>();

        ArrayList<Item> actual = cart.onSaleItems();

        assertIterableEquals(expected, actual, "Should not return any items when nothing is on sale");
    }

}
