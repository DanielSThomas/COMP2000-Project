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

    private DatabaseController databaseController;
    private GUIController guiController;

    public EditStockTypeView()
    {

        editStockTypeView = this;
        databaseController = new DatabaseController();
        guiController = new GUIController();

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
                guiController.InitialiseGui("AdminView");
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

                guiController.InitialiseGui("AdminView");
                guiController.ChangePage(editStockTypeView, guiController.adminView);
            }
        });
    }


    }

