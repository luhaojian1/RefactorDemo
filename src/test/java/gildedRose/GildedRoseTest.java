package gildedRose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void should_item_quality_is_2_when_updateQuality_given_item_name_is_Knife_and_quality_is_3() {

        Item item = new Item("Knife", 10, 3);
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);

        Item[] result = gildedRose.updateQuality();

        assertEquals(2, items[0].quality);
    }


}
