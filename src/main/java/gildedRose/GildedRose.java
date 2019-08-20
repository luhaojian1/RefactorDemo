package gildedRose;

import java.util.Arrays;

public class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEachOrdered(Item::update);
    }
}
