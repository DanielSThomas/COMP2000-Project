package com.controller;

import com.model.Database;
import com.model.StockType;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KioskUserControllerTest
{
    private KioskUserController kioskUserController = new KioskUserController();
    private StockType[] stockTypes;
    private StockType mango;
    private StockType apple;
    Database database = new Database();

    @BeforeEach
    void onSetup()
    {
        
        // Create Stock barcodes
        ArrayList<String> barcodes01 = new ArrayList<>();
        barcodes01.add("ma000111000");
        barcodes01.add("ma000222000");

        ArrayList<String> barcodes02 = new ArrayList<>();
        barcodes02.add("ap000111000");

        // Create Stock Types
        mango = new StockType("Mango", new BigDecimal("1.75"),2, barcodes01);

        apple = new StockType("Apple", new BigDecimal("0.99"),1,barcodes02);

        Database.getInstance().stockType.add(mango);
    }

    @AfterEach
    void onTearDown()
    {
        Database.getInstance().basket.clear();
        Database.getInstance().stockType.clear();
    }

    @Test
    void scanItem() // Scans for corresponding barcodes in database and removes them. Then also adds the item to the basket.
    {

        System.out.println(Database.getInstance().stockType.get(0).getAllInfo());

        System.out.println(Database.getInstance().basket.size() + " Items in basket");

        kioskUserController.ScanItem("ma000111000");

        System.out.println(Database.getInstance().stockType.get(0).getAllInfo());

        System.out.println(Database.getInstance().basket.size() + " Items in basket");

        kioskUserController.ScanItem("ma000222000");

        System.out.println(Database.getInstance().stockType.get(0).getAllInfo());

        System.out.println(Database.getInstance().basket.size() + " Items in basket");

        assertEquals(Database.getInstance().stockType.get(0).getBarcodes().size(), 0);

        assertEquals(Database.getInstance().basket.size(), 2);

    }

    @Test
    void calculateTotalBasket() // Calculates the current cost of the kiosk basket stored in the Database
    {

        kioskUserController.CalculateTotalBasket();
        System.out.println("Basket total : £ " + Database.getInstance().basketTotal);

        System.out.println("Adding mango to basket");
        Database.getInstance().basket.add(mango);

        kioskUserController.CalculateTotalBasket();
        System.out.println("Basket total : £ " + Database.getInstance().basketTotal);

        System.out.println("Adding 2nd mango to basket");
        Database.getInstance().basket.add(mango);

        kioskUserController.CalculateTotalBasket();
        System.out.println("Basket total : £ " + Database.getInstance().basketTotal);

        System.out.println("Adding apple to basket");
        Database.getInstance().basket.add(apple);

        kioskUserController.CalculateTotalBasket();
        System.out.println("Basket total : £ " + Database.getInstance().basketTotal);

        assertEquals(Database.getInstance().basketTotal, new BigDecimal("4.49"));

    }

}