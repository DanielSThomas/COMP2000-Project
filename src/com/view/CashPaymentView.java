package com.view;

import com.controller.GUIController;

import javax.swing.*;
import java.awt.*;

public class CashPaymentView extends JFrame
{
    private JPanel cashPanel;
    private JButton completePaymentButton;
    private JTextField txtCashOverride;
    private JButton btnCashoverride;

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


    }



}
