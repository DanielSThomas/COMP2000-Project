package com.controller;


import com.model.Database;
import com.model.Payment;
import com.model.Receipt;
import com.view.KioskView;
import com.view.LoginView;

import javax.swing.*;

public class KioskUserController

{

    public DatabaseController databaseController;

    public Payment payment;

    public Receipt receipt;

    public void AddToBasket(Integer index)
    {
        Database.getInstance().basket.add(Database.getInstance().stockType.get(index));

        Database.getInstance().stockType.get(index).getBarcodes().remove(0);

        Database.getInstance().stockType.get(index).updateItemCount();

        databaseController.SaveStockData();



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

    public void Scan()
    {

    }

    public void Pay()
    {

    }

    public void VerifyCard()
    {


    }

    public void InitialiseDataBaseController()
    {
        databaseController = new DatabaseController();
    }


    public void UpdateView()
    {

    }

}
