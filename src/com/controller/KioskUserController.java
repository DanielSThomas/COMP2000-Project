package com.controller;


import com.model.Database;
import com.model.Payment;
import com.view.KioskView;
import com.view.LoginView;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class KioskUserController

{

    public DatabaseController databaseController;

    public void AddToBasket(Integer index)
    {

        Database.getInstance().basket.add(Database.getInstance().stockType.get(index));

        Database.getInstance().stockType.get(index).getBarcodes().remove(0);

        Database.getInstance().stockType.get(index).updateItemCount();



    }

    public void ScanItem(String barcode)
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


                }
            }

        }

    }

    public void CalculateTotalBasket()
    {
        BigDecimal totalCost = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal singleCost = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);


        for (int i = 0; i < Database.getInstance().basket.size(); i++)
        {

            singleCost = Database.getInstance().basket.get(i).getPrice();
            totalCost = totalCost.add(singleCost);

        }

        Database.getInstance().basketTotal = totalCost;

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
