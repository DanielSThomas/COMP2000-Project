package com.model;

import com.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String name;

    private int itemCount;

    private int price;

    public List<Item> item = new ArrayList<Item> ();

    int getItemCount()
    {

        return this.itemCount;

    }

    void setItemCount(int value)
    {

        this.itemCount = value;

    }

    int getPrice()
    {

        return this.price;

    }

    void setPrice(int value)
    {

        this.price = value;

    }

}
