package com.controller;


import com.model.Payment;
import com.model.Receipt;
import com.model.Item;
import com.model.Stock;
import com.view.KioskView;
import com.view.LoginView;

import javax.swing.*;

public class KioskUserController

{
    public Item[] basket;

    public Stock stockController;

    public Payment payment;

    public Receipt receipt;

    public LoginView loginView;

    public KioskView kioskView;

    public void Scan()
    {

    }

    public void Pay()
    {

    }

    public void VerifyCard()
    {


    }

    public void InitialiseGui()
    {
        kioskView = new KioskView();
        //kioskView.setVisible(true);

        loginView = new LoginView();

    }

    public void ChangePage(JFrame currentPage, JFrame targetPage)
    {
        currentPage.setVisible(false);


        targetPage.setVisible(true);

        currentPage.dispose();
    }

    public void UpdateView()
    {

    }

}
