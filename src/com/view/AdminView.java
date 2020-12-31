package com.view;


import com.controller.DatabaseController;
import com.controller.GUIController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class AdminView extends JFrame
{
    public DatabaseController databaseController;

    private JList lstStockTypes;
    private JList lstStock;
    private JButton btnDeleteStock;
    private JButton button2;
    private JButton BtnOrderStock;
    private JButton btnRefresh;
    private JButton btnDeleteStockType;
    private JButton btnEditStockType;
    private JButton btnCreateStockType;
    private JButton button8;
    private JButton logoutButton;
    private JPanel adminPanel;
    private AdminView adminView;
    private DefaultListModel<String> defaultListModel;
    private DefaultListModel<String> defaultListModel2;
    private Integer selectedIndex;
    private Integer selectedIndex2;

    public AdminView()
    {
        adminView = this;


        DatabaseController databaseController = new DatabaseController();
        GUIController guiController = new GUIController();
        adminView.setContentPane(adminPanel);
        adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminView.setPreferredSize(new Dimension(500,500));
        adminView.pack();
        databaseController.LoadStockData();

        defaultListModel = new DefaultListModel<String>();
        defaultListModel2 = new DefaultListModel<String>();

        databaseController.viewStockType(defaultListModel,lstStockTypes);




        logoutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui();
                guiController.ChangePage(adminView, guiController.kioskView);
            }
        });

        btnCreateStockType.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui();
                guiController.ChangePage(adminView, guiController.createStockTypeView);
            }
        });


        lstStockTypes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                selectedIndex = lstStockTypes.getSelectedIndex();
                databaseController.viewStock(selectedIndex,lstStock,defaultListModel2);
            }
        });

        BtnOrderStock.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                databaseController.orderStock(selectedIndex);
                databaseController.SaveStockData();



                databaseController.viewStock(selectedIndex,lstStock,defaultListModel2);

                //databaseController.viewStockType(defaultListModel,lstStockTypes);// Needs threading or something, causes crash if viewstock runs at same time
                }
                catch (Exception e1)
                {
                    System.out.println(e1);
                }

            }
        });

        btnRefresh.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                adminView.dispose();
                guiController.InitialiseGui();
                guiController.ChangePage(guiController.loginView, guiController.adminView); //This is bad :(
            }
        });
    }




}
