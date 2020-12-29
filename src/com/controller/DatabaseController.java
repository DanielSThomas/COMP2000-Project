package com.controller;

import com.model.Admin;
import com.model.Database;
import com.model.Stock;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController
{

    public void LoadStockData()
    {
        try
        {
            Database.getInstance().stock.clear();

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

                Stock tempStock = new Stock(name,Double.parseDouble(price),numberInStock,barcodes);

                Database.getInstance().stock.add(tempStock);

                name = br.readLine();

            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }




    public void CrudOperations(com.model.Stock stock)
    {

    }

    public void UpdateView()
    {

    }

}
