package com.example.gadsleadershipboardapp.model;

public class LearningLeader {

    private String name;
    private String country;
    private int hours;
    private String badgeUrl;

    public LearningLeader(String name, int hours, String country, String badgeUrl) {
        this.setName(name);
        this.setHours(hours);
        this.setCountry(country);
        this.setBadgeUrl(badgeUrl);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
