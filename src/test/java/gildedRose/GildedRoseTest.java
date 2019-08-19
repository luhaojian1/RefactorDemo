package gildedRose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void should_item_quality_is_2_when_updateQuality_given_item_name_is_Knife_and_quality_is_3() {

        Item item = new Item("Knife", 10, 3);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(2, items[0].quality);
    }

    @Test
    public void should_item_quality_is_0_when_updateQuality_given_item_name_is_Knife_and_quality_is_0_and_sellIn_is_20() {

        Item item = new Item("Knife", 20, 0);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    public void should_item_quality_is_1_when_updateQuality_given_item_name_is_Aged_Brie_and_quality_is_0_and_sellIn_is_20() {

        Item item = new Item("Aged Brie", 20, 0);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(1, items[0].quality);
    }

    @Test
    public void should_item_quality_is_3_when_updateQuality_given_item_name_is_Sulfuras_Hand_of_Ragnaros_and_quality_is_3_and_sellIn_is_20() {

        Item item = new Item("Sulfuras, Hand of Ragnaros", 20, 3);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(3, items[0].quality);
    }

    @Test
    public void should_item_quality_is_2_when_updateQuality_given_item_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_0_and_sellIn_is_10() {

        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(2, items[0].quality);
    }

    @Test
    public void should_item_quality_is_3_when_updateQuality_given_item_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_0_and_sellIn_is_5() {

        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(3, items[0].quality);
    }

    @Test
    public void should_item_quality_is_1_when_updateQuality_given_item_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_0_and_sellIn_is_12() {

        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(1, items[0].quality);
    }

    @Test
    public void should_item_quality_is_1_and_sellIn_is_11_when_updateQuality_given_item_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_0_and_sellIn_is_12() {

        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(1, items[0].quality);
        assertEquals(11, items[0].sellIn);
    }

    @Test
    public void should_item_quality_is_1_and_sellIn_is__2_when_updateQuality_given_item_name_is_Backstage_passes_and_quality_is_2_and_sellIn_is_less_than_0() {

        Item item = new Item("Backstage passes", -1, 2);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(-2, items[0].sellIn);
    }

    @Test
    public void should_item_quality_is_0_and_sellIn_is__2_when_updateQuality_given_item_name_is_Backstage_passes_and_quality_is_0_and_sellIn_is_less_than_0() {

        Item item = new Item("Backstage passes", -1, 0);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(-2, items[0].sellIn);
    }

    @Test
    public void should_item_quality_is_0_when_updateQuality_given_item_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_3_and_sellIn_is_less_than_0() {

        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 3);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    public void should_item_quality_is_5_when_updateQuality_given_item_name_is_Aged_Brie_and_quality_is_3_and_sellIn_is_less_than_0() {

        Item item = new Item("Aged Brie", -1, 3);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(5, items[0].quality);
    }
}
