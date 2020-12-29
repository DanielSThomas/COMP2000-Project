package com.model;

import java.util.ArrayList;
import java.util.List;

public class Database
{
    // static variable single_instance of type Singleton
    private static Database single_instance = null;


    public List<StockType> stockType = new ArrayList<StockType>();

    public List<Admin> admins = new ArrayList<Admin>();





    // static method to create instance of Singleton class
    public static Database getInstance()
    {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }


}
