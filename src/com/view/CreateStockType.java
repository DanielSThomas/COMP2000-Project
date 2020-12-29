package com.view;

import com.controller.DatabaseController;
import com.controller.GUIController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateStockType extends JFrame
{
    private JPanel createStockTypePanel;
    private JTextField txtStockTypeName;
    private JTextField txtStockTypePrice;
    private JButton btnApply;
    private JButton btnCancel;
    private CreateStockType createStockType;


    public CreateStockType()
    {
        createStockType = this;

        DatabaseController databaseController = new DatabaseController();
        GUIController guiController = new GUIController();

        createStockType.setContentPane(createStockTypePanel);
        createStockType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createStockType.setPreferredSize(new Dimension(500,500));
        createStockType.pack();



        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui();
                guiController.ChangePage(createStockType, guiController.adminView);
            }
        });

        btnApply.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                databaseController.createStockType(txtStockTypeName.getText(),txtStockTypePrice.getText());
                databaseController.SaveStockData();

                guiController.InitialiseGui();
                guiController.ChangePage(createStockType, guiController.adminView);
            }
        });
    }


}
