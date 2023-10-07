package com.gildedrose;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// ./gradlew jacocoTestR


class GildedRoseTest {
  private Item[] items;
  private GildedRose appUnderTest;

 


  @Test
 void test_qualite_sedegrade_deux_fois_si_la_date_de_péremption_est_passée() {


    items = new Item[] {new Item("+5 Dexterity Vest", 0, 80)};
    appUnderTest = new GildedRose(items);
    appUnderTest.updateQuality();
    assertEquals(78, appUnderTest.items[0].quality);

  }

  @Test
  void test_qualite_toujours_positive() {
  //Arrange 
    items = new Item[] { new Item("+5 Dexterity Vest", 0, 0)};
    appUnderTest = new GildedRose(items);
    //Act
    appUnderTest.updateQuality();
  //Assert
    assertEquals(0, appUnderTest.items[0].quality);

  }

    @Test
 void test_produit_Aged_augmente_sa_qualite_plus_le_temps_passe() {
    //Arrange 
    items = new Item[] { new Item("Aged Brie", 2, 0)};
    appUnderTest = new GildedRose(items);
    //Act
    appUnderTest.updateQuality();
  //Assert
    assertEquals(1, appUnderTest.items[0].quality);

  }
  @Test
  void test_produit_Sulfuras_ne_perd_jamais_en_qualité() {
    // Arrange 
    items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80),
    new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
    appUnderTest = new GildedRose(items);
    //Act
    appUnderTest.updateQuality();
    //Assert
    for(int i=0; i<items.length; i++ ) {
    assertEquals(80, appUnderTest.items[i].quality);
    }
  }


  @Test
  void test_Backstagepasses_augmente_sa_qualité_de_deux() {
    //Arrange
    items = new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48)};
    appUnderTest = new GildedRose(items);

    //Act 
    appUnderTest.updateQuality();

    //Assert
    assertEquals(50, appUnderTest.items[0].quality);

  }

  @Test
  void test_Backstagepasses_augmente_sa_qualité_de_un(){
    //Arrange
    items = new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 12, 48)};
    appUnderTest = new GildedRose(items);

    //Act 
    appUnderTest.updateQuality();

    //Assert
    assertEquals(49, appUnderTest.items[0].quality);

  }


  @Test
  void test_Backstagepasses_augmente_sa_qualité_de_trois() {
    //Arrange
    items = new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 4, 40)};
    appUnderTest = new GildedRose(items);

    //Act 
    appUnderTest.updateQuality();

    //Assert
    assertEquals(43, appUnderTest.items[0].quality);

  }

  @Test
  void test_qualité_produit_ne_depasse_jamais_50() {
    //Arrange
    items = new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49)};
    appUnderTest = new GildedRose(items);

    //Act 
    appUnderTest.updateQuality();

    //Assert
    assertEquals(50, appUnderTest.items[0].quality);

  }

  @Test
  void test_backstage_apres_concert() {
    items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -5, 49)};
     appUnderTest = new GildedRose(items);

    //Act 
    appUnderTest.updateQuality();

    //Assert
    assertEquals(0, appUnderTest.items[0].quality);

  }

  @Test
  void test_qualite_augmente_de_1() {
        //Arrange
    items = new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50)};
    appUnderTest = new GildedRose(items);

    //Act 
    appUnderTest.updateQuality();

    //Assert
    assertEquals(50, appUnderTest.items[0].quality);
  }

  @Test
  void test_sellin_inf_0() {
    items = new Item[] {new Item("Aged Brie", -2, 12)};
    appUnderTest = new GildedRose(items);
    appUnderTest.updateQuality();

    assertEquals(14, appUnderTest.items[0].quality);
  }

    @Test
  void test_sellin_sup_0_et_quantite_sup_50() {
    items = new Item[] {new Item("Aged Brie", -10, 50)};
    appUnderTest = new GildedRose(items);
    appUnderTest.updateQuality();

    assertEquals(50, appUnderTest.items[0].quality);
  }

}
