package com.view;

import com.controller.KioskUserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame
{
    private JPanel loginPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton btnCancel;
    private LoginView loginView;

    public LoginView()
    {
        loginView = this;
        KioskUserController kioskUserController = new KioskUserController();
        loginView.setContentPane(loginPanel);
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginView.setPreferredSize(new Dimension(500,500));
        loginView.pack();

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                kioskUserController.InitialiseGui();
                kioskUserController.ChangePage(loginView, kioskUserController.kioskView);
                //loginView.dispose();
            }
        });
    }
}
