package com.view;



import com.controller.GUIController;
import com.controller.KioskUserController;

import javax.swing.*;
import javax.swing.text.ChangedCharSetException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentView extends JFrame
{

    public KioskUserController kioskUserController;
    private JPanel paymentPanel;
    private JButton btnCash;
    private JButton btnCard;
    private JLabel lblPaymentType;

    private PaymentView paymentView;


    public PaymentView()
    {
        //Adds reference to "this" page
        paymentView = this;

        //KioskUserController kioskUserController = new KioskUserController();
        GUIController guiController = new GUIController();
        paymentView.setContentPane(paymentPanel);
        paymentView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paymentView.setPreferredSize(new Dimension(500,500));
        paymentView.pack();

        btnCash.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui("CashPaymentView");
                guiController.ChangePage(paymentView, guiController.cashPaymentView);
            }
        });

        btnCard.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui("ValidationView");
                guiController.ChangePage(paymentView, guiController.validationView);
            }
        });
    }





}
