package com.controller;

import com.model.Database;
import com.model.StockType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KioskUserControllerTest
{
    private KioskUserController kioskUserController;
    private StockType[] stockTypes;



    @Test
    void addToBasket()
    {

    }

    @Test
    void scanItem()
    {

        //setup

        kioskUserController = new KioskUserController();

        Database database = new Database();

        ArrayList<String> barcodes01 = new ArrayList<>();
        barcodes01.add("bc000111000");
        barcodes01.add("bc000222000");

        StockType stockType01 = new StockType("Mango", new BigDecimal("1.75"),2, barcodes01);

        Database.getInstance().stockType.add(stockType01);

        //test

        System.out.println(Database.getInstance().stockType.get(0).getAllInfo());

        kioskUserController.ScanItem("bc000111000");

        System.out.println(Database.getInstance().stockType.get(0).getAllInfo());

        kioskUserController.ScanItem("bc000222000");

        System.out.println(Database.getInstance().stockType.get(0).getAllInfo());

        assertEquals(Database.getInstance().stockType.get(0).getBarcodes().size(), 0);


    }

    @Test
    void calculateTotalBasket()
    {

    }

    @Test
    void viewStockType()
    {

    }

    @Test
    void viewBasket()
    {

    }

}