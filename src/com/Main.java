package com;

import com.controller.GUIController;

public class Main
{

    public static void main(String[] args)
    {

        GUIController guiController = new GUIController();

        guiController.InitialiseGui("LoginView");
        guiController.InitialiseGui("KioskView");
        guiController.ChangePage(guiController.loginView, guiController.kioskView);

    }

}
