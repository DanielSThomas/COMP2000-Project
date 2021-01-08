package com.view;

import com.controller.GUIController;
import com.controller.PaymentController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ValidationView extends JFrame
{
    private JButton btnForceFail;
    private JButton btnForcePass;
    private JPanel validationPanel;
    private JButton btnReturn;

    private PaymentController paymentController;
    private GUIController guiController;

    private ValidationView validationView;


    public ValidationView()
    {

        validationView = this;
        guiController = new GUIController();
        paymentController = new PaymentController();

        validationView.setContentPane(validationPanel);
        validationView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        validationView.pack();


        btnForcePass.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                paymentController.CardValidation(true);
                paymentController.StorePaymentDetails();

                guiController.InitialiseGui("ReceiptView");
                guiController.ChangePage(validationView, guiController.receiptView);
            }
        });

        btnForceFail.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                paymentController.CardValidation(false);


            }
        });

        btnReturn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui("PaymentView");
                guiController.ChangePage(validationView,guiController.paymentView);
            }
        });
    }
}
