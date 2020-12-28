package com.model;

import com.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Stock
{
    private String name;

    private int itemCount;

    private double price;

    private List<Item> item = new ArrayList<Item> ();

    public Stock (String newname, double newprice)
    {
        name = newname;
        price = newprice;
    }

    public void addItem()
    {

    }

    public String getAllInfo()
    {
        String _string = new String("Name: " + name + " In Stock: " + itemCount + " Price: £" + price );
        return _string;
    }

    public void ItemCount()
    {
        itemCount = item.size();
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
