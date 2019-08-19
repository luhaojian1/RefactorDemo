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
        for (Item item : items) {

            if (!isNameEquals(item, AGED_BRIE)
                    && !isNameEquals(item, BACKSTAGE)) {
                SelfDecrementWhenQualityMoreThanZeroAndNotNamedSulfuras(item);
            } else {
                if (item.quality < 50) {
                    item.quality++;
                    if (isNameEquals(item, BACKSTAGE)) {
                        QualityIncrementIfSellInMoreThan(item, 11);
                        QualityIncrementIfSellInMoreThan(item, 6);
                    }
                }
            }

            SellInDecrementIfNameNotSulfuras(item);

            if (item.sellIn < 0) {
                if (!isNameEquals(item, AGED_BRIE)) {
                    if (!isNameEquals(item, BACKSTAGE)) {
                        SelfDecrementWhenQualityMoreThanZeroAndNotNamedSulfuras(item);
                    } else {
                        item.quality = 0;
                    }
                } else {
                    selfIncrementIfQualityLessThanFifty(item);
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
