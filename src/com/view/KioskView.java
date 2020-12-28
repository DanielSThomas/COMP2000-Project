package com.view;


import com.controller.KioskUserController;
import com.model.Database;
import com.model.Stock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KioskView extends JFrame
{
    public Stock[] inStock;



    public LoginView loginView;

    public KioskUserController kioskUserController;
    private JButton btnFandP;
    private JButton btnLogin;
    private JTable tblStock;
    private JButton btnAddItem;
    private JTable table1;
    private JButton btnRemoveItem;
    private JPanel kioskPanel;
    private JTextField txtTemp;
    private KioskView kioskView;



    public KioskView()
    {
        kioskView = this;
        kioskUserController = new KioskUserController();
        kioskUserController.InitialiseDataBaseController();
        kioskUserController.databaseController.LoadStockData();
        kioskView.setContentPane(kioskPanel);
        kioskView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kioskView.setPreferredSize(new Dimension(500,500));
        kioskView.pack();


        btnLogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {



                kioskUserController.InitialiseGui();
                kioskUserController.ChangePage(kioskView, kioskUserController.loginView);

            }
        });
    }


    public void AddToBasket()
    {

    }

    public void FinishAndPay()
    {

    }





}
