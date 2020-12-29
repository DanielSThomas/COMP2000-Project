package com.view;

import com.controller.GUIController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame
{
    private JPanel loginPanel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;

    private LoginView loginView;



    public LoginView()
    {
        //Adds reference to "this" page
        loginView = this;

        //KioskUserController kioskUserController = new KioskUserController();
        GUIController guiController = new GUIController();
        loginView.setContentPane(loginPanel);
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginView.setPreferredSize(new Dimension(500,500));
        loginView.pack();

        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui();
                guiController.ChangePage(loginView, guiController.kioskView);

            }
        });

        btnLogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (txtUsername.getText().equals("admin")) //Placeholder login
                {
                    guiController.InitialiseGui();
                    guiController.ChangePage(loginView, guiController.adminView);
                }


            }
        });
    }
}
