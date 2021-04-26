package com.galvanize.cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void createItemWithName() {
        Item item = new Item("Vase", 10.99, false);
        String expected = "Vase";
        String actual = item.name;
        assertEquals(expected, actual, "Item is initialized with a name");
    }

    @Test
    public void createItemWithPrice() {
        Item item = new Item("Vase", 10.99, false);
        Double expected = 10.99;
        Double actual = item.price;
        assertEquals(expected, actual, "Item is initialized with a price");
    }

    @Test
    public void createItemWithOnSale() {
        Item item = new Item("Vase", 10.99, false);
        boolean expected = false;
        boolean actual = item.isOnSale;
        assertEquals(expected, actual, "Item is initialized with a isOnsale value");
    }
}
