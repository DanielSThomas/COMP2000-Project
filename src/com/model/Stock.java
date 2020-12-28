package com.model;

import com.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Stock
{
    private String name;

    private int itemCount;

    private double price;

    private List<Item> items = new ArrayList<Item> ();

    public Stock (String newName, double newPrice, List<Item> newItems)
    {
        name = newName;
        price = newPrice;
        items = newItems;
    }

    public void addItem(Item value)
    {
        items.add(value);
    }

    public String getAllInfo()
    {
        String _string = new String("Name: " + name + " In Stock: " + itemCount + " Price: £" + price );
        return _string;
    }

    public void updateItemCount()
    {
        itemCount = items.size();
    }


    public int getItemCount()
    {

        return this.itemCount;

    }

    public void setItemCount(int value)
    {

        this.itemCount = value;

    }

    public double getPrice()
    {

        return this.price;

    }

    public void setPrice(int value)
    {

        this.price = value;

    }

}
