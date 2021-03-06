package com.view;

import com.controller.GUIController;
import com.controller.PaymentController;
import com.model.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashPaymentView extends JFrame
{
    private JPanel cashPanel;
    private JButton btnCompletePayment;
    private JTextField txtCashOverride;
    private JButton btnCashoverride;
    private JButton btnReturn;
    private JLabel lblAmountDue;
    private JLabel lblAmountPaid;
    private JLabel lblChange;

    private CashPaymentView cashPaymentView;
    private PaymentController paymentController;
    private GUIController guiController;



    public CashPaymentView()
    {

            //Adds reference to "this" page
            cashPaymentView = this;
            paymentController = new PaymentController();
            guiController = new GUIController();

            cashPaymentView.setContentPane(cashPanel);
            cashPaymentView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            lblAmountDue.setText("Amount due : £" + String.valueOf(Database.getInstance().basketTotal));

            cashPaymentView.pack();


        btnReturn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui("PaymentView");
                guiController.ChangePage(cashPaymentView, guiController.paymentView);
            }
        });

        btnCompletePayment.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                paymentController.StorePaymentDetails();

                guiController.InitialiseGui("ReceiptView");
                guiController.ChangePage(cashPaymentView, guiController.receiptView);
            }
        });

        btnCashoverride.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

              paymentController.CalculateCash(txtCashOverride, lblAmountPaid);

              lblChange.setText("Change : £" + paymentController.CalculateChange());


              if (paymentController.cashAdded.doubleValue() >= paymentController.cashDue.doubleValue())
              {
                  btnCompletePayment.setEnabled(true);

              }

            }
        });
    }



}
