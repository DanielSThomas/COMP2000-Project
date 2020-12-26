package com;

import com.controller.KioskUserController;
import com.view.KioskView;

import javax.swing.*;

public class Main
{
    //private JFrame kioskView;



    public static void main(String[] args)
    {

        KioskUserController kioskUserController = new KioskUserController();
        kioskUserController.InitialiseGui();
        kioskUserController.ChangePage(kioskUserController.loginView, kioskUserController.kioskView);



    }

    public void Startup()
    {
       // kioskView = new KioskView();

      //  kioskView.isVisible();

    }
}
