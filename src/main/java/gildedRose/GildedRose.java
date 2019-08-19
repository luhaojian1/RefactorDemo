package gildedRose;

public class GildedRose {
    Item[] items;
    private String sulfuras = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                if (items[i].quality > 0) {

                    if (!items[i].name.equals(sulfuras)) {
                        items[i].quality--;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality++;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality++;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality++;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(sulfuras)) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(sulfuras)) {
                                items[i].quality--;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality++;
                    }
                }
            }
        }
    }
}
