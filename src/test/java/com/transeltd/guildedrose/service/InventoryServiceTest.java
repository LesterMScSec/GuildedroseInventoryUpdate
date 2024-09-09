package com.transeltd.guildedrose.service;

import com.transeltd.guildedrose.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    private InventoryService inventoryService;
    private Item item;
    private List<Item> listOfItems;

    @BeforeEach
    void setUp() {
        listOfItems = new ArrayList<>();
        inventoryService = new InventoryService();
        item = new Item("Aged Brie", 1, 1);
        listOfItems.add(item);
        item = new Item("Normal Item", 2, 2);
        listOfItems.add(item);
        item = new Item("Backstage passes", 9, 2);
        listOfItems.add(item);
        item = new Item("Conjured", 2, 2);
        listOfItems.add(item);
        item = new Item("Sulfuras", 2, 2);
        listOfItems.add(item);
    }

    @Test
    void testUpdateInventory() {
        inventoryService.updateInventory(listOfItems);

        // Test for Aged Brie Item
        assertEquals(0, listOfItems.get(0).getSellIn());
        assertEquals(2, listOfItems.get(0).getQuality());

        // Test for Normal Item
        assertEquals(1, listOfItems.get(1).getSellIn());
        assertEquals(1, listOfItems.get(1).getQuality());
    }
    @Test
    void testAgedBrieIncreaseQuality() {
        Item agedBrieItem = new Item("Aged Brie", 1, 1);
        inventoryService.updateInventory(Arrays.asList(agedBrieItem));
        assertEquals( 2, agedBrieItem.getQuality() );
        assertEquals( 0, agedBrieItem.getSellIn() );
    }

    @Test
    void testNormalItemDecreaseQuality() {
        Item normalItem = new Item("Normal Item", -1, 55);
        inventoryService.updateInventory(Arrays.asList(normalItem));
        assertEquals( 53, normalItem.getQuality() );
        assertEquals( -2, normalItem.getSellIn() );
    }

    @Test
    void testBackstagePassesIncreaseQuality() {
        Item backStageitem = new Item("Backstage passes", 9, 2);
        inventoryService.updateInventory(Arrays.asList(backStageitem));
        assertEquals( 4, backStageitem.getQuality() );
        assertEquals( 8, backStageitem.getSellIn() );
    }

    @Test
    void testSulfurasDoesNotChange() {
        Item sulfurasItem = new Item("Sulfuras", 2, 2);
        inventoryService.updateInventory(Arrays.asList(sulfurasItem));
        assertEquals( 2, sulfurasItem.getQuality() );
        assertEquals( 2, sulfurasItem.getSellIn() );
    }

    @Test
    void testConjuredItemsDegradeTwiceAsFast() {
        Item conjuredItem = new Item("Conjured", 2, 2);
        inventoryService.updateInventory(Arrays.asList(conjuredItem));
        assertEquals( 0, conjuredItem.getQuality() );
        assertEquals( 1, conjuredItem.getSellIn() );
    }

    @Test
    void testInvalidItem() {
        Item conjuredItem = new Item("INVALID ITEM", 2, 2);
        inventoryService.updateInventory(Arrays.asList(conjuredItem));
        assertEquals( "NO SUCH ITEM", inventoryService.getMessage() );
     }
}