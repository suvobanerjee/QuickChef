package com.suvo.quickchef.model;

/**
 * Created by suvo on 3/2/2017.
 */

public class MainMenu {

    private String typeOfRecipe;
    private String subtitle;
    private int thumbnail;


    public MainMenu() {
    }

    public MainMenu(String typeOfRecipe, String subtitle, int thumbnail) {
        this.typeOfRecipe = typeOfRecipe;
        this.subtitle = subtitle;
        this.thumbnail = thumbnail;
    }

    public String getTypeOfRecipe() {
        return typeOfRecipe;
    }

    public void setTypeOfRecipe(String typeOfRecipe) {
        this.typeOfRecipe = typeOfRecipe;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
