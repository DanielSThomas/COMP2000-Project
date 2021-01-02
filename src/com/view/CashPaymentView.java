package com.view;

import com.controller.GUIController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashPaymentView extends JFrame
{
    private JPanel cashPanel;
    private JButton completePaymentButton;
    private JTextField txtCashOverride;
    private JButton btnCashoverride;
    private JButton btnReturn;

    private CashPaymentView cashPaymentView;



    public CashPaymentView()
    {

            //Adds reference to "this" page
            cashPaymentView = this;

            GUIController guiController = new GUIController();
            cashPaymentView.setContentPane(cashPanel);
            cashPaymentView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cashPaymentView.setPreferredSize(new Dimension(500,500));
            cashPaymentView.pack();


        btnReturn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui();
                guiController.ChangePage(cashPaymentView, guiController.paymentView);
            }
        });

        completePaymentButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui();
                guiController.ChangePage(cashPaymentView, guiController.receiptView);
            }
        });
    }



}
