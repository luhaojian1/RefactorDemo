package gildedRose;

public class GildedRose {
    private Item[] items;
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!isNameEquals(item, AGED_BRIE) && !isNameEquals(item, BACKSTAGE)) {
                SelfDecrementWhenQualityMoreThanZeroAndNotNamedSulfuras(item);

            } else {
                if (item.getQuality() < 50) {
                    System.out.println(222);
                    item.setQuality(item.getQuality() + 1);
                    if (isNameEquals(item, BACKSTAGE)) {
                        QualityIncrementIfSellInMoreThan(item, 11);
                        QualityIncrementIfSellInMoreThan(item, 6);
                    }
                }
            }

            SellInDecrementIfNameNotSulfuras(item);

            if (item.getSellIn() < 0) {
                if (!isNameEquals(item, AGED_BRIE)) {
                    if (!isNameEquals(item, BACKSTAGE)) {
                        SelfDecrementWhenQualityMoreThanZeroAndNotNamedSulfuras(item);
                    } else {
                        item.setQuality(0);
                    }
                } else {

                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);

                    }
                }
            }
        }
    }

    private void QualityIncrementIfSellInMoreThan(Item item, int sellIn) {
        if (item.getSellIn() < sellIn) {
            selfIncrementIfQualityLessThanFifty(item);
        }
    }

    private void SellInDecrementIfNameNotSulfuras(Item item) {
        if (!isNameEquals(item, SULFURAS_HAND_OF_RAGNAROS)) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    private void selfIncrementIfQualityLessThanFifty(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private void SelfDecrementWhenQualityMoreThanZeroAndNotNamedSulfuras(Item item) {
        if (item.getQuality() > 0) {
            if (!isNameEquals(item, SULFURAS_HAND_OF_RAGNAROS)) {
                item.setQuality(item.getQuality() - 1);
            }
        }
    }

    private boolean isNameEquals(Item item, String agedBrie) {
        return item.getName().equals(agedBrie);
    }

    public Item[] getItems() {
        return items;
    }
}
