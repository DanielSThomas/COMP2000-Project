package com.controller;

import com.model.Database;
import com.model.StockType;
import com.sun.source.tree.CatchTree;

import javax.swing.*;
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
            br.close();


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public void SaveStockData()
    {
        

       try
        {
            File stockData = new File("src/data/StockData.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(stockData)));
            //BufferedWriter bw = new BufferedWriter(new FileWriter(stockData));

            for (StockType stocktype: Database.getInstance().stockType)
            {

                pw.println(stocktype.getName());

                pw.println(String.valueOf(stocktype.getPrice()));

                pw.println(String.valueOf(stocktype.getNumberInStock()));

                for (int i = 0; i < stocktype.getNumberInStock(); i++)
                {
                    pw.println(stocktype.getBarcodes().get(i));
                }
            }
            pw.close();

        }
         catch (IOException e)
        {
            e.printStackTrace();
        }



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

    public void viewStock(Integer index,JList<String> jList, DefaultListModel<String> defaultListModel)
    {
        defaultListModel.clear();

        for (int i = 0; i < Database.getInstance().stockType.get(index).getBarcodes().size(); i++)
        {
            defaultListModel.add(i,Database.getInstance().stockType.get(index).getBarcodes().get(i));
        }

        jList.setModel(defaultListModel);



    }



}
