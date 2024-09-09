package com.transeltd.guildedrose.service;

import com.transeltd.guildedrose.model.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Getter
public class InventoryService implements IinventoryService{

    private final Map<String, Iitem> itemMap = new HashMap<>();
    private String message;

    public InventoryService() {
        itemMap.put("Aged Brie", new AgedBrieItem());
        itemMap.put("Sulfuras", new SulfurasItem());
        itemMap.put("Conjured", new ConjuredItem());
        itemMap.put("Normal Item", new NormalItem());
        itemMap.put("Backstage passes", new BackStagePassesItem());
    }

    public void updateInventory(List<Item> items) {
        for (Item item : items) {
            Iitem anItem = itemMap.get(item.getName());
            if(anItem != null) {
                anItem.updateItem(item);
            } else {
                message = "NO SUCH ITEM";
            }
        }
    }
}
