package com.transeltd.guildedrose.model;

import lombok.Getter;

@Getter
public class SulfurasItem implements Iitem {

    private String message;
    @Override
    public void updateItem(Item item) {
        message = item.getName() + " does not change";
    }
}
