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
            updateNormalItem(item);
            updateAgedItem(item);
            updateBackStageItem(item);
            updateSulfurasItem(item);
        }
    }

    private void updateNormalItem(Item item) {
        boolean isNormalItem = !isNameEquals(item, AGED_BRIE) && !isNameEquals(item, SULFURAS_HAND_OF_RAGNAROS) && !isNameEquals(item, BACKSTAGE);
        if (isNormalItem) {
            if (item.getQuality() > 0) {
                item.setQuality(item.getQuality() - 1);
            }
            item.setSellIn(item.getSellIn() - 1);
            if (item.getSellIn() < 0) {
                if (item.getQuality() > 0) {
                    item.setQuality(item.getQuality() - 1);
                }
            }
        }
    }

    private void updateAgedItem(Item item) {
        if (isNameEquals(item, AGED_BRIE)) {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }
            item.setSellIn(item.getSellIn() - 1);
            if (item.getSellIn() < 0) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }

        }
    }

    private void updateBackStageItem(Item item) {
        if (isNameEquals(item, BACKSTAGE)) {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
                QualityIncrementIfSellInMoreThan(item, 11);
                QualityIncrementIfSellInMoreThan(item, 6);
            }
            item.setSellIn(item.getSellIn() - 1);
            if (item.getSellIn() < 0) {
                item.setQuality(0);
            }

        }
    }

    private void updateSulfurasItem(Item item) {
        if (isNameEquals(item, SULFURAS_HAND_OF_RAGNAROS)) {
            if (item.getSellIn() < 0) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }

    private void QualityIncrementIfSellInMoreThan(Item item, int sellIn) {
        if (item.getSellIn() < sellIn) {
            selfIncrementIfQualityLessThanFifty(item);
        }
    }

    private void selfIncrementIfQualityLessThanFifty(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private boolean isNameEquals(Item item, String agedBrie) {
        return item.getName().equals(agedBrie);
    }

}
