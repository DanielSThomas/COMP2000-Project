package com;

import com.controller.KioskUserController;
import com.model.Database;
import com.view.KioskView;

import javax.swing.*;

public class Main
{
    //private JFrame kioskView;


    public static void main(String[] args)
    {
        Database database = Database.getInstance();

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
