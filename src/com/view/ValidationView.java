package com.view;

import com.controller.GUIController;

import javax.swing.*;
import java.awt.*;

public class ValidationView extends JFrame
{
    private JButton btnForceFail;
    private JButton btnForcePass;
    private JPanel validationPanel;

    private ValidationView validationView;


    public ValidationView()
    {

        validationView = this;

        GUIController guiController = new GUIController();
        validationView.setContentPane(validationPanel);
        validationView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validationView.setPreferredSize(new Dimension(500,500));
        validationView.pack();


    }
}
