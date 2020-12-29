package com.controller;

import com.model.Database;
import com.model.StockType;

import java.io.*;
import java.util.ArrayList;

public class DatabaseController
{

    public void LoadStockData()
    {
        try
        {
            Database.getInstance().stockType.clear();

            File stockData = new File("src/data/StockData.txt");

            BufferedReader br = new BufferedReader(new FileReader(stockData));

            String name = br.readLine();
            while (name != null)
            {
                String price = br.readLine();
                int numberInStock = Integer.parseInt(br.readLine());
                ArrayList<String> barcodes = new ArrayList<String>();
                for (int i = 0; i < numberInStock ; i++)
                {
                    barcodes.add(br.readLine());
                }

                StockType tempStockType = new StockType(name,Double.parseDouble(price),numberInStock,barcodes);

                Database.getInstance().stockType.add(tempStockType);

                name = br.readLine();

            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public void SaveStockData()
    {

    }

    public void createStockType(String name, String price)
    {
        Integer numberInStock = 0;
        ArrayList<String> barcodes = new ArrayList<String>();

        StockType tempStockType = new StockType(name,Double.parseDouble(price),numberInStock,barcodes);
        Database.getInstance().stockType.add(tempStockType);
    }

    public void editStockType()
    {

    }

    public void deleteStockType()
    {
        
    }



}
