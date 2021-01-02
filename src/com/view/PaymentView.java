package com.view;



import com.controller.GUIController;
import com.controller.KioskUserController;

import javax.swing.*;
import java.awt.*;

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

    }





}
