package com.controller;


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

    public LoginView loginView;

    public KioskView kioskView;

    public String passData;

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


    public void InitialiseGui()
    {
        kioskView = new KioskView();

        loginView = new LoginView();
    }

    public void ChangePage(JFrame currentPage, JFrame targetPage)
    {
        currentPage.setVisible(false);

        targetPage.setVisible(true);

        //Might be unnecessary as the current page is always overwritten by InitialiseGui anyway.
        currentPage.dispose();
    }


    public void UpdateView()
    {

    }

}
