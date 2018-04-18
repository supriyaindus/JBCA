package com.jbca;

/**
 * Created by supriyamitra on 16/09/17.
 */

public class Member {
    private String name;
    private String position;
    private int thumbnail;
    private String number;

    public Member() {
    }

    public Member(String name, String position, int thumbnail, String number) {
        this.name = name;
        this.position = position;
        this.thumbnail = thumbnail;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
