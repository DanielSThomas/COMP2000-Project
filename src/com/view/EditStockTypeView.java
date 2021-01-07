package com.view;

import com.controller.DatabaseController;
import com.controller.GUIController;
import com.model.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class EditStockTypeView extends JFrame
{
    private JPanel editStockTypePanel;
    private JButton btnApply;
    private JButton btnCancel;
    private JTextField txtStockTypeName;
    private JTextField txtStockTypePrice;
    private EditStockTypeView editStockTypeView;

    public EditStockTypeView()
    {

        editStockTypeView = this;

        DatabaseController databaseController = new DatabaseController();
        GUIController guiController = new GUIController();

        editStockTypeView.setContentPane(editStockTypePanel);
        editStockTypeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtStockTypeName.setText(Database.getInstance().stockType.get(Database.getInstance().storedInt).getName());
        txtStockTypePrice.setText(String.valueOf(Database.getInstance().stockType.get(Database.getInstance().storedInt).getPrice()));

        editStockTypeView.pack();



        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui();
                guiController.ChangePage(editStockTypeView, guiController.adminView);
            }
        });

        btnApply.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                databaseController.editStockType(Database.getInstance().storedInt, txtStockTypeName.getText(), new BigDecimal(txtStockTypePrice.getText()));
                databaseController.SaveStockData();

                guiController.InitialiseGui();
                guiController.ChangePage(editStockTypeView, guiController.adminView);
            }
        });
    }


    }

