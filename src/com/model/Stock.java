package com.model;



import java.util.ArrayList;
import java.util.List;

public class Stock
{

    private String name;

    private int numberInStock;

    private double price;

    private ArrayList<String> barcodes;

    public Stock (String newName, double newPrice, ArrayList<String> newBarcodes)
    {
        name = newName;
        price = newPrice;
        barcodes = newBarcodes;
    }

    public void addBarcode(String value)
    {
        barcodes.add(value);
    }

    public String getAllInfo()
    {
        String _string = new String("Name: " + name + " In Stock: " + numberInStock + " Price: £" + price );
        return _string;
    }

    public void updateItemCount()
    {
        numberInStock = barcodes.size();
    }




    public int getNumberInStock()
    {

        return this.numberInStock;

    }

    public void setItemCount(int value)
    {

        this.numberInStock = value;

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
