package com.controller;

import com.model.Database;
import com.model.StockType;
import com.sun.source.tree.CatchTree;

import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;
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

                StockType tempStockType = new StockType(name, new BigDecimal(price),numberInStock,barcodes);

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

    public void viewStockType(DefaultListModel<String> defaultListModel, JList jList)
    {
        defaultListModel.clear();
        for (int i = 0; i < Database.getInstance().stockType.size(); i++)
        {
            defaultListModel.add(i,Database.getInstance().stockType.get(i).getAllInfo());

            if(Database.getInstance().stockType.get(i).getNumberInStock() < 10)
            {
                defaultListModel.set(i,Database.getInstance().stockType.get(i).getAllInfo() + " !WARNING LOW STOCK! ");
            }
        }

        jList.setModel(defaultListModel);
    }

    public void createStockType(String name, String price)
    {
        Integer numberInStock = 0;
        ArrayList<String> barcodes = new ArrayList<String>();

        StockType tempStockType = new StockType(name, new BigDecimal(price),numberInStock,barcodes);
        Database.getInstance().stockType.add(tempStockType);
    }

    public void editStockType(Integer index, String newName, BigDecimal newPrice)
    {
        Database.getInstance().stockType.get(index).setName(newName);
        Database.getInstance().stockType.get(index).setPrice(newPrice);
    }

    public void deleteStockType(Integer index)
    {
        Database.getInstance().stockType.remove(index.intValue());
    }

    public void orderStock(Integer index, Integer orderCount)
    {
        for (int i = 0; i < orderCount; i++)
        {
            String frontBarcode;
            String backBarcode;
            String barcode;


            frontBarcode = Database.getInstance().stockType.get(index).getName().substring(0,2);
            backBarcode = String.valueOf(System.currentTimeMillis() + Database.getInstance().stockType.get(index).getBarcodes().size());
            barcode = frontBarcode + backBarcode;

            //Method to order stock

            //Confirm stock arrived

            Database.getInstance().stockType.get(index).addBarcode(barcode);
            Database.getInstance().stockType.get(index).updateItemCount();
        }


    }

    public void deleteStock(Integer parentIndex, Integer childIndex)
    {
        Database.getInstance().stockType.get(parentIndex).getBarcodes().remove(childIndex.intValue());
        Database.getInstance().stockType.get(parentIndex).updateItemCount();
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
