package com.example.ross.masterdetail.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        addItem(createDummyItem("CSC101", "Intro to CS", "An introduction to computer science"));
        addItem(createDummyItem("CSC206", "Operating systems", "Discusses low level programming"));
        addItem(createDummyItem("ENG101", "Intro to Literary Studies", "An introduction to poetry and fiction"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(String number, String name, String details) {
        return new DummyItem(String.valueOf(number), name, details);
    }

//    private static String makeDetails(String details) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(details);
//        for (int i = 0; i < details; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
