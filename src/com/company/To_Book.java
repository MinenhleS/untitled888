package com.company;

import java.util.Date;

public class To_Book {
    private int ID;
    private int ID_Institution;
    private int price;
    private int count_guest;
    private Date date_book;
    private boolean access;


    public To_Book(int ID, int ID_Institution, int price, int count_guest, Date date_book, boolean access) {
        this.ID = ID;
        this.ID_Institution = ID_Institution;
        this.price = price;
        this.count_guest = count_guest;
        this.date_book = date_book;
        this.access = access;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setID_Institution(int ID_Institution) {
        this.ID_Institution = ID_Institution;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount_guest(int count_guest) {
        this.count_guest = count_guest;
    }

    public void setDate_book(Date date_book) {
        this.date_book = date_book;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public int getID() {
        return ID;
    }

    public int getID_Institution() {
        return ID_Institution;
    }

    public int getPrice() {
        return price;
    }

    public int getCount_guest() {
        return count_guest;
    }

    public Date getDate_book() {
        return date_book;
    }

    public boolean isAccess() {
        return access;
    }
}
