package com.model;

public class Database
{
    // static variable single_instance of type Singleton
    private static Database single_instance = null;

    // private constructor restricted to this class itself
    private Database()
    {

    }

        public String temp;



    // static method to create instance of Singleton class
    public static Database getInstance()
    {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }


}
