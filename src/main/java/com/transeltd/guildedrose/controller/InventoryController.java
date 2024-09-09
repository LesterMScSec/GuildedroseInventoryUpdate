package com.transeltd.guildedrose.controller;

import com.transeltd.guildedrose.model.Item;
import com.transeltd.guildedrose.service.InventoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(final InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("update")
    public List<Item> updateInventory(@RequestBody List<Item> listOfItems) {
        inventoryService.updateInventory(listOfItems);
        return listOfItems;
    }


}
