package com.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Database
{

    private static Database single_instance = null;

    // Placeholder variable used to transfer a Integer
    public Integer storedInt = 0;


    //Stock Data
    public ArrayList<StockType> stockType = new ArrayList<StockType>();

    
    //Payment / Kiosk Data
    public ArrayList<StockType> basket = new ArrayList<StockType>();


    public Payment payment;

    public BigDecimal basketTotal = new BigDecimal("0.0").setScale(2, RoundingMode.HALF_EVEN);



    // Create instance of Singleton class
    public static Database getInstance()
    {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }


}
