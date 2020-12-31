package com.controller;

import com.view.*;

import javax.swing.*;

public class GUIController
{
    public LoginView loginView;

    public KioskView kioskView;

    public AdminView adminView;

    public CreateStockTypeView createStockTypeView;

    public EditStockTypeView editStockTypeView;




    public void InitialiseGui()
    {

        kioskView = new KioskView();

        loginView = new LoginView();

        adminView = new AdminView();

        createStockTypeView = new CreateStockTypeView();

        editStockTypeView = new EditStockTypeView();

    }

    public void ChangePage(JFrame currentPage, JFrame targetPage)
    {
        InitialiseGui();

        currentPage.setVisible(false);

        targetPage.setLocation(currentPage.getLocation());

        targetPage.setSize(currentPage.getSize());

        targetPage.setVisible(true);

        //Might be unnecessary as the current page is always overwritten by InitialiseGui anyway.
        currentPage.dispose();
    }


}
