package com.uxsmobile.gotcharacters.model;

import java.io.Serializable;

/**
 * Created by Afll on 09/08/2017.
 */

public class Character implements Serializable{
    private String name, actor, house;
    private String imageLink;

    public Character(String name, String actor, String house, String imageLink) {
        this.name = name;
        this.actor = actor;
        this.house = house;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    //Serializable methods

}
