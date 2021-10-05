package com.company;

public class Institution {
    private int ID;
    private String name;
    private String location;
    private String type;

    public Institution(int ID, String name, String location, String type) {
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
