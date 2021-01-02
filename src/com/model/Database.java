package com.model;

import java.util.ArrayList;
import java.util.List;

public class Database
{
    // static variable single_instance of type Singleton
    private static Database single_instance = null;

    // Placeholder variable used to transfer a Integer between Views or Controllers
    public Integer storedInt = 0;


    public CashPayment cashPayment;

    //Stock / Admin data
    public List<StockType> stockType = new ArrayList<StockType>();

    public List<Admin> admins = new ArrayList<Admin>();


    //Payment / Kiosk Data
    public List<StockType> basket = new ArrayList<StockType>();

    public Double basketTotal = 0.0;




    // static method to create instance of Singleton class
    public static Database getInstance()
    {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }


}
