package com.view;

import com.controller.KioskUserController;
import com.model.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame
{
    private JPanel loginPanel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLoad;
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

        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                kioskUserController.InitialiseGui();
                kioskUserController.ChangePage(loginView, kioskUserController.kioskView);

            }
        });

        btnLoad.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                txtUsername.setText(Database.getInstance().temp);

            }
        });
    }
}
