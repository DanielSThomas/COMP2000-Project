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
    private JPanel kioskPanel;
    private JList lstStock;
    private JList lstBasket;
    private JLabel lblTotalCost;
    private JTextField txtBarcode;
    private JButton btnScan;
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


        kioskView.setContentPane(kioskPanel);
        kioskView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kioskView.setPreferredSize(new Dimension(500,500));
        kioskUserController.ViewBasket(defaultListModel2,lstBasket);
        lblTotalCost.setText("Total Cost £" + String.valueOf(Database.getInstance().basketTotal));


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

                    kioskUserController.CalculateTotalBasket();
                    lblTotalCost.setText("Total Cost £" + String.valueOf(Database.getInstance().basketTotal));
                }

                catch(Exception e1)
                {

                }
            }
        });


        btnFandP.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui();
                guiController.ChangePage(kioskView, guiController.paymentView);
            }
        });

        btnScan.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                kioskUserController.ScanItem(txtBarcode.getText());

                kioskUserController.ViewBasket(defaultListModel2,lstBasket);
                kioskUserController.ViewStockType(defaultListModel, lstStock);

                kioskUserController.CalculateTotalBasket();
                lblTotalCost.setText("Total Cost £" + String.valueOf(Database.getInstance().basketTotal));
            }
        });
    }








}
