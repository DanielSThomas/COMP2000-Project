package com.view;


import com.controller.KioskUserController;
import com.model.Stock;
import com.model.Item;

import javax.swing.*;
import java.awt.*;

public class KioskView extends JFrame
{
    public Stock[] inStock;

    public Item[] basketList;

    public KioskUserController kioskUserController;
    private JButton btnFandP;
    private JButton btnLogin;
    private JTable tblStock;
    private JButton btnAddItem;
    private JTable table1;
    private JButton btnRemoveItem;
    private JPanel kioskPanel;

    public KioskView()
    {
        this.setContentPane(kioskPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,500));
        this.pack();

        this.setVisible(true);
    }


    public void AddToBasket()
    {

    }

    public void FinishAndPay()
    {

    }



}
