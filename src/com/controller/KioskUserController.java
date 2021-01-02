package com.controller;


import com.model.Database;
import com.model.Payment;
import com.model.Receipt;
import com.view.KioskView;
import com.view.LoginView;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.text.DecimalFormat;

public class KioskUserController

{

    public DatabaseController databaseController;

    public void AddToBasket(Integer index)
    {

        Database.getInstance().basket.add(Database.getInstance().stockType.get(index));

        Database.getInstance().stockType.get(index).getBarcodes().remove(0);

        Database.getInstance().stockType.get(index).updateItemCount();

        databaseController.SaveStockData();
    }

    public void ScanItem(String barcode) // Only usable in UnitTest
    {
        for (int i = 0; i < Database.getInstance().stockType.size(); i++)
        {
            for (int j = 0; j < Database.getInstance().stockType.get(i).getBarcodes().size() ; j++)
            {
                if(barcode.equals(Database.getInstance().stockType.get(i).getBarcodes().get(j)))
                {
                    Database.getInstance().basket.add(Database.getInstance().stockType.get(i));
                    Database.getInstance().stockType.get(i).getBarcodes().remove(j);

                    Database.getInstance().stockType.get(i).updateItemCount();

                    databaseController.SaveStockData();
                }
            }

        }


    }

    public void CalculateTotalBasket()
    {
        double totalCost = 0.0;
        double singleCost = 0.0;

        DecimalFormat decimalFormat = new DecimalFormat("##.00");


        for (int i = 0; i < Database.getInstance().basket.size(); i++)
        {

            singleCost = Database.getInstance().basket.get(i).getPrice();
            totalCost += Double.parseDouble(decimalFormat.format(singleCost));

        }



        Database.getInstance().basketTotal = Double.parseDouble(decimalFormat.format(totalCost));




    }

    public void ViewStockType(DefaultListModel<String> defaultListModel, JList jList)
    {
        defaultListModel.clear();
        for (int i = 0; i < Database.getInstance().stockType.size(); i++)
        {
            defaultListModel.add(i,Database.getInstance().stockType.get(i).getAllInfo());
        }

        jList.setModel(defaultListModel);
    }

    public void ViewBasket(DefaultListModel<String> defaultListModel, JList jList)
    {
        defaultListModel.clear();
        for (int i = 0; i < Database.getInstance().basket.size(); i++)
        {
            defaultListModel.add(i,Database.getInstance().basket.get(i).getBasketInfo());
        }

        jList.setModel(defaultListModel);
    }

    public void InitialiseDataBaseController()
    {
        databaseController = new DatabaseController();
    }



}
