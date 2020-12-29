package com;

import com.controller.GUIController;
import com.model.Database;

public class Main
{
    //private JFrame kioskView;


    public static void main(String[] args)
    {
        Database database = Database.getInstance();

        GUIController guiController = new GUIController();
        guiController.InitialiseGui();
        guiController.ChangePage(guiController.loginView, guiController.kioskView);

    }

    public void Startup()
    {
       // kioskView = new KioskView();

      //  kioskView.isVisible();

    }
}
