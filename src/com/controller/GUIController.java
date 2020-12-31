package com.controller;

import com.view.AdminView;
import com.view.CreateStockTypeView;
import com.view.KioskView;
import com.view.LoginView;

import javax.swing.*;

public class GUIController
{
    public LoginView loginView;

    public KioskView kioskView;

    public AdminView adminView;

    public CreateStockTypeView createStockTypeView;




    public void InitialiseGui()
    {
        //Create Case Statements ?
        kioskView = new KioskView();

        loginView = new LoginView();

        adminView = new AdminView();

        createStockTypeView = new CreateStockTypeView();

    }

    public void ChangePage(JFrame currentPage, JFrame targetPage)
    {
        currentPage.setVisible(false);

        targetPage.setLocation(currentPage.getLocation());

        targetPage.setSize(currentPage.getSize());

        targetPage.setVisible(true);


        //Might be unnecessary as the current page is always overwritten by InitialiseGui anyway.
        currentPage.dispose();
    }


}
