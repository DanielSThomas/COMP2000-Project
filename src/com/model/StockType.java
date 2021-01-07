package com.model;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class StockType
{

    private String name;

    private BigDecimal price;

    private int numberInStock;

    private ArrayList<String> barcodes;



    public StockType(String newName, BigDecimal newPrice, int newNumberInStock, ArrayList<String> newBarcodes)
    {
        name = newName;
        price = newPrice.setScale(2, RoundingMode.HALF_EVEN);
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

    public BigDecimal getPrice()
    {

        return this.price.setScale(2,RoundingMode.HALF_EVEN);

    }

    public void setPrice(BigDecimal value)
    {

        this.price = value.setScale(2,RoundingMode.HALF_EVEN);

    }

}
