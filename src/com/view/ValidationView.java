package com.view;

import com.controller.GUIController;

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

    private ValidationView validationView;


    public ValidationView()
    {

        validationView = this;

        GUIController guiController = new GUIController();
        validationView.setContentPane(validationPanel);
        validationView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validationView.setPreferredSize(new Dimension(500,500));
        validationView.pack();


        btnForcePass.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                showMessageDialog(null, "Payment Accepted");
                guiController.InitialiseGui();
                guiController.ChangePage(validationView, guiController.receiptView);
            }
        });

        btnForceFail.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                showMessageDialog(null, "!Card Payment Failed!. Please try again or use another payment method.");
            }
        });

        btnReturn.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui();
                guiController.ChangePage(validationView,guiController.paymentView);
            }
        });
    }
}
