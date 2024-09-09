package com.transeltd.guildedrose.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Item {
    private String name;
    private int sellIn;
    private int quality;

    /*
      Override toString method as not decide what our class will return
      as its default implementation from Object class just returns the
      class name and its hashcode
     */
    public String toStrting() {
        return name + " " + sellIn + " " + quality;
    }
}
