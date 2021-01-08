package com.view;

import com.controller.GUIController;
import com.controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import static javax.swing.JOptionPane.showMessageDialog;

public class LoginView extends JFrame
{
    private JPanel loginPanel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private LoginController loginController;
    private GUIController guiController;

    private LoginView loginView;



    public LoginView()
    {
        //Adds reference to "this" page
        loginView = this;
        guiController = new GUIController();
        loginController = new LoginController();

        loginView.setContentPane(loginPanel);
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginView.setPreferredSize(new Dimension(500,500));
        loginView.pack();

        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guiController.InitialiseGui("KioskView");
                guiController.ChangePage(loginView, guiController.kioskView);
            }
        });

        btnLogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                   if (loginController.Login(txtUsername.getText(),txtPassword.getPassword())== true)
                   {

                       guiController.InitialiseGui("AdminView");
                       guiController.ChangePage(loginView, guiController.adminView);
                   }
                   else
                   {
                       showMessageDialog(null, "Invalid Username or Password");
                   }
                }
                catch (NoSuchAlgorithmException | InvalidKeySpecException noSuchAlgorithmException)
                {
                    noSuchAlgorithmException.printStackTrace();
                }

            }
        });
    }
}
