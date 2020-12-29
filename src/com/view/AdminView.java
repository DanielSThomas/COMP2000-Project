package com.view;


import com.controller.DatabaseController;
import com.controller.GUIController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public AdminView()
    {
        adminView = this;

        //KioskUserController kioskUserController = new KioskUserController();
        GUIController guiController = new GUIController();
        adminView.setContentPane(adminPanel);
        adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminView.setPreferredSize(new Dimension(500,500));
        adminView.pack();


        logoutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui();
                guiController.ChangePage(adminView, guiController.kioskView);
            }
        });
    }

}
