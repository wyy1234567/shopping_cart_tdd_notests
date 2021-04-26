package com.galvanize.cart;

import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    // When initialize a cart, make sure it's empty
    @Test
    public void createEmptyCart() {

        Cart cart = new Cart();
        ArrayList<Item> expected = new ArrayList<>();
        ArrayList<Item> actual = cart.itemizedList;
        assertIterableEquals(expected, actual, "Initialize with an empty cart");
    }

    @Test
    public void creatItemWithPrice() {
        Item item = new Item(10.99);
        Double expected = 10.99;
        Double actual = item.price;
        assertEquals(expected, actual, "Item is initialized with a price");
    }

    @Test
    public void addItemToCart() {
        Item item = new Item(10);
        Cart cart = new Cart();

        cart.addToCart(item);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item);
        ArrayList<Item> actual = cart.itemizedList;
        assertIterableEquals(expected, actual, "Able to add an item to the cart");

    }

    @Test
    public void getTotalPrice() {
        Item item = new Item(12.13);
        Cart cart = new Cart();

        double expected = 12.13;
        cart.addToCart(item);
        double actual = cart.getTotalPrice();

        assertEquals(expected, actual, "Cart knowing total price of items in it");

        Item item1 = new Item(20.99);

        expected = 12.13 + 20.99;
        cart.addToCart(item1);
        actual = cart.getTotalPrice();

        assertEquals(expected, actual, "Cart knowing total price of items in it");
    }
}
