package com.view;


import com.controller.GUIController;
import com.controller.KioskUserController;
import com.model.Database;
import com.model.StockType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.ScatteringByteChannel;

public class KioskView extends JFrame
{
    public StockType[] inStockType;



    public LoginView loginView;

    public KioskUserController kioskUserController;
    private JButton btnFandP;
    private JButton btnLogin;
    private JButton btnAddItem;
    private JButton btnRemoveItem;
    private JPanel kioskPanel;
    private JList lstStock;
    private JList lstBasket;
    private KioskView kioskView;
    private DefaultListModel<String> defaultListModel;
    private DefaultListModel<String> defaultListModel2;
    private Integer selectedIndex;
    private Integer selectedIndex2;


    public KioskView()
    {
        kioskView = this;
        GUIController guiController = new GUIController();
        kioskUserController = new KioskUserController();
        kioskUserController.InitialiseDataBaseController();
        kioskUserController.databaseController.LoadStockData();



        defaultListModel = new DefaultListModel<String>();
        defaultListModel2 = new DefaultListModel<String>();

        kioskUserController.ViewStockType(defaultListModel, lstStock);

//        for (int i = 0; i < Database.getInstance().stockType.size(); i++)
//        {
//            defaultListModel.add(i,Database.getInstance().stockType.get(i).getAllInfo());
//        }
//
//
//
//        lstStock.setModel(defaultListModel);
        kioskView.setContentPane(kioskPanel);
        kioskView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kioskView.setPreferredSize(new Dimension(500,500));
        kioskUserController.ViewBasket(defaultListModel2,lstBasket);









        kioskView.pack();


        btnLogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {



                guiController.InitialiseGui();
                guiController.ChangePage(kioskView, guiController.loginView);

            }
        });

        btnRemoveItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        btnAddItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    selectedIndex = lstStock.getSelectedIndex();
                    kioskUserController.AddToBasket(selectedIndex);

                    kioskUserController.ViewBasket(defaultListModel2,lstBasket);
                    kioskUserController.ViewStockType(defaultListModel, lstStock);
                }

                catch(Exception e1)
                {

                }
            }
        });
    }








}
