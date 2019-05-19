package com.ydprojects.websitescraper.entity.data;

public class Item {

    private String title;
    private String kcal_per_100g;
    private String unit_price;
    private String description;


    public Item(String title, String kcal_per_100g, String unit_price, String description) {
        this.title = title;
        this.kcal_per_100g = kcal_per_100g;
        this.unit_price = unit_price;
        this.description = description;
    }

}
