package com.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Database
{
    // static variable single_instance of type Singleton
    private static Database single_instance = null;

    // Placeholder variable used to transfer a Integer between Views or Controllers
    public Integer storedInt = 0;


    public Payment payment;

    //Stock / Admin data
    public ArrayList<StockType> stockType = new ArrayList<StockType>();



    //Payment / Kiosk Data
    public ArrayList<StockType> basket = new ArrayList<StockType>();

    public BigDecimal basketTotal = new BigDecimal("0.0").setScale(2, RoundingMode.HALF_EVEN);




    // static method to create instance of Singleton class
    public static Database getInstance()
    {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }


}
