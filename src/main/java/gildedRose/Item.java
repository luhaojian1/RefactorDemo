package gildedRose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    private ItemUpdater itemUpdater;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Item(String name, int sellIn, int quality, ItemUpdater itemUpdater) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.itemUpdater = itemUpdater;
    }

    public void update() {
        itemUpdater.update(this);
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
