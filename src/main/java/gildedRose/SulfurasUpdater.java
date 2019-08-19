package gildedRose;

public class SulfurasUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        if (item.getSellIn() < 0) {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }
        }
    }
}
