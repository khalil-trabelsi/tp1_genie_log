package com.gildedrose;

class GildedRose {
    static final int QUALITY_MAX_VALUE = 50;
    static final int BACKSTAGE_SELLIN_MAX = 11;
    static final int BACKSTAGE_SELLIN_MAX1 = 6;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;

    }


    private void updateQualityBackStage(Item item) {
            increaseQuality(item);
            if(item.sellIn < BACKSTAGE_SELLIN_MAX) {
                increaseQuality(item);
            }
            if(item.sellIn < BACKSTAGE_SELLIN_MAX1 ) {
                increaseQuality(item);
            }
            
        item.sellIn = item.sellIn - 1;
        if(item.sellIn<0) {
            item.quality = 0;
        }
      
    }

    private void increaseQuality(Item item) {
        if (item.quality <QUALITY_MAX_VALUE) {
            item.quality+=1;
        }
    }

    private void qualityProductDegrade(Item item) {
        if(item.quality>0) {
            item.quality -=1;
        }
        item.sellIn = item.sellIn - 1;
        if(item.sellIn<0) {
            if(item.quality > 0) {
                item.quality = item.quality -1;

            }
        }

    }

    public void updateQualityAgedBrie(Item item) {
       increaseQuality(item);
        item.sellIn = item.sellIn - 1;
        if(item.sellIn <0) {
       increaseQuality(item);
        }

    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            switch(items[i].name) {
                case "Aged Brie": {
                    updateQualityAgedBrie(items[i]);
                    break;
                }
                 case "Backstage passes to a TAFKAL80ETC concert": {
                    updateQualityBackStage(items[i]);
                    break;
                }
                case "Sulfuras, Hand of Ragnaros":
                break;
                default: 
                qualityProductDegrade(items[i]);
                break;
                
            }
        }
    }


}