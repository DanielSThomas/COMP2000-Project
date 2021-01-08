package com.view;


import com.controller.DatabaseController;
import com.controller.GUIController;
import com.model.Database;

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
                guiController.InitialiseGui("KioskView");
                guiController.ChangePage(adminView, guiController.kioskView);
            }
        });

        btnCreateStockType.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui("CreateStockTypeView");
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
                    Number objectToInt = (Number) spnOrderStock.getValue();

                databaseController.orderStock(selectedIndex, objectToInt.intValue());
                databaseController.SaveStockData();



                databaseController.viewStock(selectedIndex,lstStock,defaultListModel2);

                btnRefresh.setBackground(Color.green);

                // databaseController.viewStockType(defaultListModel,lstStockTypes);// Needs threading or something, causes crash if viewstock runs at same time
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
                //adminView.dispose();
                guiController.InitialiseGui("AdminView");
                guiController.ChangePage(adminView, guiController.adminView);
            }
        });

        btnDeleteStockType.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectedIndex = lstStockTypes.getSelectedIndex();
                databaseController.deleteStockType(selectedIndex);
                databaseController.SaveStockData();

                //adminView.dispose();
                guiController.InitialiseGui("AdminView");
                guiController.ChangePage(adminView, guiController.adminView);

            }
        });


        btnDeleteStock.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    selectedIndex2 = lstStock.getSelectedIndex();
                    databaseController.deleteStock(selectedIndex, selectedIndex2);
                    databaseController.SaveStockData();
                    databaseController.viewStock(selectedIndex,lstStock,defaultListModel2);
                    btnRefresh.setBackground(Color.green);
                }
                catch (Exception e2)
                {

                }

            }
        });

        btnEditStockType.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Database.getInstance().storedInt = selectedIndex.intValue();
                guiController.InitialiseGui("EditStockTypeView");
                guiController.ChangePage(adminView, guiController.editStockTypeView);
            }
        });
    }




}
