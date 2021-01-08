package com.controller;

import com.view.*;

import javax.swing.*;

public class GUIController
{
    public KioskView kioskView;
    public LoginView loginView;
    public AdminView adminView;
    public CreateStockTypeView createStockTypeView;
    public EditStockTypeView editStockTypeView;
    public PaymentView paymentView;
    public CashPaymentView cashPaymentView;
    public ValidationView validationView;
    public ReceiptView receiptView;

    //Used to initialise a page (view) in preparation for ChangePage()

    public void InitialiseGui(String viewName)
    {

        switch (viewName)
        {
            case "KioskView":
            kioskView = new KioskView();
            break;

            case "LoginView":
            loginView = new LoginView();
            break;

            case "AdminView":
            adminView = new AdminView();
            break;

            case "CreateStockTypeView":
            createStockTypeView = new CreateStockTypeView();
            break;

            case "EditStockTypeView":
            editStockTypeView = new EditStockTypeView();
            break;

            case "PaymentView":
            paymentView = new PaymentView();
            break;

            case "CashPaymentView":
            cashPaymentView = new CashPaymentView();
            break;

            case "ValidationView":
            validationView = new ValidationView();
            break;

            case "ReceiptView":
            receiptView = new ReceiptView();
            break;
        }




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
