package gildedRose;

public class BackStageUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
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

    private void QualityIncrementIfSellInMoreThan(Item item, int sellIn) {
        if (item.getSellIn() < sellIn) {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }
        }
    }
}
