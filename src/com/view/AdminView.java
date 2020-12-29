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
    private JButton button2;
    private JButton BtnOrderStock;
    private JButton button4;
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

        for (int i = 0; i < Database.getInstance().stockType.size(); i++)
        {
            defaultListModel.add(i,Database.getInstance().stockType.get(i).getAllInfo());
        }

        lstStockTypes.setModel(defaultListModel);




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
                guiController.ChangePage(adminView, guiController.createStockType);
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
    }




}
