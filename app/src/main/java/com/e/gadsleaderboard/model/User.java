package com.e.gadsleaderboard.model;

public class User {
    String name;
    String hour_skill;
    String country;
    String img_url;

    public User() {
    }

    public User(String name, String hour_skill, String country, String img_url) {
        this.name = name;
        this.hour_skill = hour_skill;
        this.country = country;
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", hour_skill='" + hour_skill + '\'' +
                ", country='" + country + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHour_skill() {
        return hour_skill;
    }

    public void setHour_skill(String hour_skill) {
        this.hour_skill = hour_skill;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
