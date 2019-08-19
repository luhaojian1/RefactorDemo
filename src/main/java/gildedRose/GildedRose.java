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
            ItemUpdater updater = new NormalUpdater();
            updater.update(item);
        }
    }

    private void updateAgedItem(Item item) {
        if (isNameEquals(item, AGED_BRIE)) {
            ItemUpdater updater = new AgeUpdater();
            updater.update(item);
        }
    }

    private void updateBackStageItem(Item item) {
        if (isNameEquals(item, BACKSTAGE)) {
            ItemUpdater updater = new BackStageUpdater();
            updater.update(item);

        }
    }

    private void updateSulfurasItem(Item item) {
        if (isNameEquals(item, SULFURAS_HAND_OF_RAGNAROS)) {
            ItemUpdater updater = new SulfurasUpdater();
            updater.update(item);
        }
    }


    private boolean isNameEquals(Item item, String agedBrie) {
        return item.getName().equals(agedBrie);
    }

}
