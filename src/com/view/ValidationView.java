package com.view;

import com.controller.GUIController;
import com.controller.PaymentController;
import com.controller.ValidationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;


public class ValidationView extends JFrame
{
    private JButton btnForceFail;
    private JButton btnForcePass;
    private JPanel validationPanel;
    private JButton btnReturn;
    private JButton btnCompletePayment;

    private PaymentController paymentController;
    private GUIController guiController;

    private ValidationView validationView;

    private ValidationController validationController;



    public ValidationView()
    {

        validationView = this;
        guiController = new GUIController();
        paymentController = new PaymentController();
        validationController = new ValidationController();

        validationView.setContentPane(validationPanel);
        validationView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validationController.Initialise();



        validationView.pack();


        btnForcePass.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {


                validationController.AuthoriseCard(true);
                paymentController.StorePaymentDetails();


            }
        });

        btnForceFail.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                validationController.AuthoriseCard(false);


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

        btnCompletePayment.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(validationController.CompletePayment())
                {
                    guiController.InitialiseGui("ReceiptView");
                    guiController.ChangePage(validationView, guiController.receiptView);
                }
                else
                {
                    showMessageDialog(null, "Payment not authorised! Please make sure you have scanned a valid card first.");
                }


                //validationController.validation.CompletePayment();

            }
        });
    }
}
