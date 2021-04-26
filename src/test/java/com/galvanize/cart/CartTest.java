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
    public void createItemWithPrice() {
        Item item = new Item(10.99, false);
        Double expected = 10.99;
        Double actual = item.price;
        assertEquals(expected, actual, "Item is initialized with a price");
    }

    @Test
    public void addItemToCart() {
        Item item = new Item(10, false);
        Cart cart = new Cart();

        cart.addToCart(item);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item);
        ArrayList<Item> actual = cart.itemsList;
        assertIterableEquals(expected, actual, "Able to add an item to the cart");

    }

    @Test
    public void getTotalPrice() {
        Item item = new Item(12.13, false);
        Cart cart = new Cart();

        double expected = 12.13;
        cart.addToCart(item);
        double actual = cart.getTotalPrice();

        assertEquals(expected, actual, "Cart knowing total price of items in it");

        Item item1 = new Item(20.99, false);

        expected = 12.13 + 20.99;
        cart.addToCart(item1);
        actual = cart.getTotalPrice();

        assertEquals(expected, actual, "Cart knowing total price of items in it");
    }

    @Test
    public void itemizedList(){
        Cart cart = new Cart();
        Item item = new Item(200, false);
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(item);

        cart.addToCart(item);
        ArrayList<Item> actual = cart.itemizedList();

        assertIterableEquals(expected, actual, "itemizedList should return a list of items in the cart");


    }

    @Test
    public void itemQuantities(){
        Cart cart = new Cart();
        Item item = new Item(100, false);
        cart.addToCart(item);

        int expected = 1;
        int actual = cart.itemQuantities(item);

        assertEquals(expected, actual, "itemQuantities should return the quantity of an item placed in the cart");
    }

    @Test
    public void itemQuantitiesOfThree(){
        Cart cart = new Cart();
        Item item = new Item(100, false);
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
        Item item1 = new Item(100, false);
        Item item2 = new Item(30, false);
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
        Item item1 = new Item(80.0, true);
        Item item2 = new Item(600, false);

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
        Item item1 = new Item(800.0, true);
        Item item2 = new Item(6000, false);

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
        Item item1 = new Item(800.0, false);
        Item item2 = new Item(6000, false);

        cart.addToCart(item1);
        cart.addToCart(item2);

        ArrayList<Item> expected = new ArrayList<>();

        ArrayList<Item> actual = cart.onSaleItems();

        assertIterableEquals(expected, actual, "Should not return any items when nothing is on sale");
    }

}
