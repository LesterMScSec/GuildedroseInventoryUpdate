package com.transeltd.guildedrose.model;

public class BackStagePassesItem implements Iitem {

    @Override
    public void updateItem(Item item) {
        int sellIn = item.getSellIn();
        if (sellIn < 0) {
            item.setQuality(0);
        } else if (sellIn <= 5) {
            item.setQuality((Math.min(item.getQuality() + 3, 50)));
        } else if (sellIn <= 10) {
            item.setQuality((Math.min(item.getQuality() + 2, 50)));
        } else {
            item.setQuality((Math.min(item.getQuality() + 1, 50)));
        }
        item.setSellIn(item.getSellIn() - 1);
    }
}
