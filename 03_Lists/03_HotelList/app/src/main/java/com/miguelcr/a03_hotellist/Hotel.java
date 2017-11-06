package com.miguelcr.a03_hotellist;

/**
 * Created by miguelcampos on 3/11/17.
 */

class Hotel {
    private String name;
    private float rate;
    private int price;
    private String tags;
    private int nightlyPrice;
    private String comments;
    private float distance;
    private String urlPhoto;

    public Hotel(String name, float rate, int price, String tags, int nightlyPrice, String comments, float distance, String urlPhoto) {
        this.name = name;
        this.rate = rate;
        this.price = price;
        this.tags = tags;
        this.nightlyPrice = nightlyPrice;
        this.comments = comments;
        this.distance = distance;
        this.urlPhoto = urlPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getNightlyPrice() {
        return nightlyPrice;
    }

    public void setNightlyPrice(int nightlyPrice) {
        this.nightlyPrice = nightlyPrice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
