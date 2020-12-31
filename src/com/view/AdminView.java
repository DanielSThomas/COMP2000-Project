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
    private JButton btnOrderStock;
    private JButton btnRefresh;
    private JButton btnDeleteStockType;
    private JButton btnEditStockType;
    private JButton btnCreateStockType;
    private JButton logoutButton;
    private JPanel adminPanel;
    private JSpinner spnOrderStock;
    private JLabel OrderAmount;
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

        btnOrderStock.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Number number = (Number) spnOrderStock.getValue();


                databaseController.orderStock(selectedIndex, number.intValue());
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
