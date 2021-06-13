package com.example.shopandroid.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Content {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position)
                , "Item " + position
                , "https://lh3.googleusercontent.com/proxy/uw_BLw8PjZiDiw8NMMw4MtaNhPzodbARHvNtztrqkxfdAtEGsexc6EuOrINKGbVJ9QXDaYB6BQfGNQjueCc_pwYb0EMlQ7aH6vI"
                , new Random().nextInt(100) + 20);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String title;
        public final String imagePath;
        public final double price;


        public DummyItem(String id, String title, String imagePath, double price) {
            this.id = id;
            this.title = title;
            this.imagePath = imagePath;
            this.price = price;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}