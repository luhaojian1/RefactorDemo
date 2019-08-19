package gildedRose;

public class GildedRose {
    Item[] items;
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (!isNameEquals(items[i], AGED_BRIE)
                    && !isNameEquals(items[i], BACKSTAGE)) {
                SelfDecrementWhenQualityMoreThanZeroAndNotNamedSulfuras(items[i]);
            } else {
                if (items[i].quality < 50) {
                    items[i].quality++;
                    if (isNameEquals(items[i], BACKSTAGE)) {
                        QualityIncrementIfSellInMoreThan(items[i], 11);
                        QualityIncrementIfSellInMoreThan(items[i], 6);
                    }
                }
            }

            SellInDecrementIfNameNotSulfuras(items[i]);

            if (items[i].sellIn < 0) {
                if (!isNameEquals(items[i], AGED_BRIE)) {
                    if (!isNameEquals(items[i], BACKSTAGE)) {
                        SelfDecrementWhenQualityMoreThanZeroAndNotNamedSulfuras(items[i]);
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    selfIncrementIfQualityLessThanFifty(items[i]);
                }
            }
        }
    }

    private void QualityIncrementIfSellInMoreThan(Item item, int sellIn) {
        if (item.sellIn < sellIn) {
            selfIncrementIfQualityLessThanFifty(item);
        }
    }

    private void SellInDecrementIfNameNotSulfuras(Item item) {
        if (!isNameEquals(item, SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn--;
        }
    }

    private void selfIncrementIfQualityLessThanFifty(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void SelfDecrementWhenQualityMoreThanZeroAndNotNamedSulfuras(Item item) {
        if (item.quality > 0) {
            if (!isNameEquals(item, SULFURAS_HAND_OF_RAGNAROS)) {
                item.quality--;
            }
        }
    }

    private boolean isNameEquals(Item item, String agedBrie) {
        return item.name.equals(agedBrie);
    }
}
