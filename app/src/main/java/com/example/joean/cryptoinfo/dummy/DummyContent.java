package com.example.joean.cryptoinfo.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for the recycler view.
 */
public class DummyContent {

    // Initialize variable(s).
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();


    // This method adds a new item (a single crypto currency) to the ITEMS list.
    private static void addCryptoCurrencyItem(DummyItem item) {
        ITEMS.add(item);
    }


    /**
     * A class dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String coinRank;
        public final String coinName;
        public final String symbolText;
        public String coinWorth;
        public final String priceInBCText;
        public final String totalSupplyText;
        public final String maxSupplyText;
        public final String availableSupplyText;
        public final String volumeChangeText;
        public final String percentChange1hrText;
        public final String coinChangePercent;
        public final String percentChange7dText;







        public DummyItem(String coinRank, String coinName, String symbolText, String coinWorth, String priceInBCText, String totalSupplyText, String maxSupplyText, String availableSupplyText, String volumeChangeText, String percentChange1hrText, String coinChangePercent, String percentChange7dText) {
            this.coinRank = coinRank;
            this.coinName = coinName;
            this.coinWorth = coinWorth;
            this.priceInBCText = priceInBCText;
            this.symbolText = symbolText;
            this.totalSupplyText = totalSupplyText;
            this.maxSupplyText = maxSupplyText;
            this.availableSupplyText = availableSupplyText;
            this.volumeChangeText = volumeChangeText;
            this.percentChange1hrText = percentChange1hrText;
            this.coinChangePercent = coinChangePercent;
            this.percentChange7dText = percentChange7dText;

        }
    }
}
