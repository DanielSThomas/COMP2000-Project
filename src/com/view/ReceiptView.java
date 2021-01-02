package com.view;

import com.controller.GUIController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptView extends JFrame
{
    private JButton btnPrint;
    private JButton btnFinish;
    private JList lstReceipt;
    private JPanel receiptPanel;

    private ReceiptView receiptView;

    public ReceiptView()
    {
        receiptView = this;

        GUIController guiController = new GUIController();
        receiptView.setContentPane(receiptPanel);
        receiptView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        receiptView.setPreferredSize(new Dimension(500,500));
        receiptView.pack();

        btnFinish.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                guiController.InitialiseGui();
                guiController.ChangePage(receiptView, guiController.kioskView);

            }
        });
    }
}
