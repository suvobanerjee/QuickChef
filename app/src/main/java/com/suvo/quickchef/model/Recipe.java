package com.suvo.quickchef.model;

/**
 * Created by suvo on 3/6/2017.
 */

public class Recipe {

    int thumbnail,vegNonVeg;
    String title,subtitle;


    public Recipe(int thumbnail, String title, String subtitle) {
        this.thumbnail = thumbnail;
        //this.vegNonVeg = vegNonVeg;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getVegNonVeg() {
        return vegNonVeg;
    }

    public void setVegNonVeg(int vegNonVeg) {
        this.vegNonVeg = vegNonVeg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
