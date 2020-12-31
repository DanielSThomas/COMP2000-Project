package com.model;



import java.util.ArrayList;
import java.util.List;

public class StockType
{

    private String name;

    private double price;

    private int numberInStock;

    private ArrayList<String> barcodes;

    public StockType(String newName, double newPrice, int newNumberInStock, ArrayList<String> newBarcodes)
    {
        name = newName;
        price = newPrice;
        numberInStock = newNumberInStock;
        barcodes = newBarcodes;
    }

    public void addBarcode(String value)
    {
        barcodes.add(value);
    }


    public String getAllInfo()
    {
        String _string = new String( name + " £" + price + " < " + numberInStock + " In stock >" );
        return _string;
    }

    public String getBasketInfo()
    {
        String _string = new String(name + " £" + price);
        return _string;
    }

    public void updateItemCount()
    {
        numberInStock = barcodes.size();
    }

    public ArrayList<String> getBarcodes()
    {
        return barcodes;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public void setPrice(double value)
    {

        this.price = value;

    }

}
