package com.model;

import java.util.ArrayList;
import java.util.List;

public class Database
{
    // static variable single_instance of type Singleton
    private static Database single_instance = null;

    public String temp;

    public List<Stock> stock = new ArrayList<Stock>();

    //Temp testing
    public void addStock()
    {
        Stock Apple = new Stock("Apple",20.00);
        stock.add(Apple);

    }





    // static method to create instance of Singleton class
    public static Database getInstance()
    {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }


}
