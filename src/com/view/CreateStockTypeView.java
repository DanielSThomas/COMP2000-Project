package com.view;

import com.controller.DatabaseController;
import com.controller.GUIController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateStockTypeView extends JFrame
{
    private JPanel createStockTypePanel;
    private JTextField txtStockTypeName;
    private JTextField txtStockTypePrice;
    private JButton btnApply;
    private JButton btnCancel;
    private CreateStockTypeView createStockTypeView;


    public CreateStockTypeView()
    {
        createStockTypeView = this;

        DatabaseController databaseController = new DatabaseController();
        GUIController guiController = new GUIController();

        createStockTypeView.setContentPane(createStockTypePanel);
        createStockTypeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createStockTypeView.pack();



        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui("AdminView");
                guiController.ChangePage(createStockTypeView, guiController.adminView);
            }
        });

        btnApply.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                databaseController.createStockType(txtStockTypeName.getText(),txtStockTypePrice.getText());
                databaseController.SaveStockData();

                guiController.InitialiseGui("AdminView");
                guiController.ChangePage(createStockTypeView, guiController.adminView);
            }
        });
    }


}
