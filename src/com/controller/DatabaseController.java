package com.controller;

import com.model.Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController
{

    public void LoadStockData()
    {
        try
        {
            File stockData = new File("src/data/StockData.txt");


            BufferedReader br = new BufferedReader(new FileReader(stockData));

            String string;

            while ((string = br.readLine()) != null)
            {
                System.out.println(string);
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
