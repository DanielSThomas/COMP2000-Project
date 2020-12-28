package com.view;


import com.controller.KioskUserController;
import com.model.Database;
import com.model.Stock;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.xml.crypto.Data;
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
    private JButton btnAddItem;
    private JButton btnRemoveItem;
    private JPanel kioskPanel;
    private JTextField txtTemp;
    private JList lstStock;
    private JList lstBasket;
    private KioskView kioskView;
    private DefaultListModel<String> defaultListModel;


    public KioskView()
    {
        kioskView = this;
        kioskUserController = new KioskUserController();
        kioskUserController.InitialiseDataBaseController();
        kioskUserController.databaseController.LoadStockData();
        defaultListModel = new DefaultListModel<String>();

        for (int i = 0; i < Database.getInstance().stock.size(); i++)
        {
            defaultListModel.add(i,Database.getInstance().stock.get(i).getAllInfo());
        }



        lstStock.setModel(defaultListModel);
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
