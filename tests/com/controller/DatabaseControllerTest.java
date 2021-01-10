package com.controller;

import com.model.Database;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseControllerTest
{


    Database database = new Database();
    DatabaseController databaseController = new DatabaseController();


    @BeforeEach
    void setUp()
    {



    }

    @AfterEach
    void tearDown()
    {
        Database.getInstance().stockType.clear();

    }

    @Test
    void loadStockData() //Tests the loading of stock data
    {
        databaseController.LoadStockData();

        for (int i = 0; i < Database.getInstance().stockType.size(); i++)
        {
            System.out.println(Database.getInstance().stockType.get(i).getAllInfo());
        }

    }

    @Test
    void loadAllStockData() //Tests the loading of stock data and individual barcodes
    {
        databaseController.LoadStockData();

        for (int i = 0; i < Database.getInstance().stockType.size(); i++)
        {
            System.out.println(Database.getInstance().stockType.get(i).getAllInfo());

            for (int j = 0; j < Database.getInstance().stockType.get(i).getBarcodes().size(); j++)
            {
                System.out.println(Database.getInstance().stockType.get(i).getBarcodes().get(j));
            }
        }

    }

    @Test
    void checkStockNumberEqualsBarcodes() //Checks that all StockTypes stock number matches the amount of barcodes.
    {
        databaseController.LoadStockData();

        for (int i = 0; i < Database.getInstance().stockType.size(); i++)
        {

            System.out.println("Testing " + Database.getInstance().stockType.get(i).getAllInfo());

            System.out.println("Barcodes present: " + Database.getInstance().stockType.get(i).getBarcodes().size());

            assertEquals(Database.getInstance().stockType.get(i).getNumberInStock(), Database.getInstance().stockType.get(i).getBarcodes().size());

        }

    }

    @Test
    void createStockType()
    {

    }

    @Test
    void editStockType()
    {


    }

    @Test
    void deleteStockType()
    {


    }

    @Test
    void orderStock()
    {


    }

    @Test
    void deleteStock()
    {


    }
}