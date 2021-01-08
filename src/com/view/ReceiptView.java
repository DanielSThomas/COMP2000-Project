package com.view;

import com.controller.GUIController;
import com.controller.PaymentController;
import com.model.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReceiptView extends JFrame
{
    private JButton btnPrint;
    private JButton btnFinish;
    private JList lstReceipt;
    private JPanel receiptPanel;

    private ReceiptView receiptView;

    private PaymentController paymentController;
    private GUIController guiController;

    private DefaultListModel defaultListModel;

    private Thread thread;

    private PanelThread panelThread;

    public boolean receiptLoaded = false;

    public ReceiptView()
    {
        receiptView = this;
        guiController = new GUIController();

        receiptView.setContentPane(receiptPanel);
        receiptView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        paymentController = new PaymentController();
        defaultListModel = new DefaultListModel();

        receiptView.pack();
        

        btnFinish.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Database.getInstance().basket.clear();
                Database.getInstance().basketTotal = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_EVEN);
                guiController.InitialiseGui("KioskView");
                guiController.ChangePage(receiptView, guiController.kioskView);

            }
        });


        btnPrint.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                if (receiptLoaded == false)
                {
                    panelThread = new PanelThread();
                    thread = new Thread(panelThread);

                    thread.start();

                }

            }
        });
    }


    public class PanelThread implements Runnable
    {
        public void run()
        {
            Thread t = Thread.currentThread();
            try
            {
                System.out.println(Thread.currentThread().getName() + " started");


                paymentController.CalculateRecipt(lstReceipt, defaultListModel);
                lstReceipt.setModel(defaultListModel);


            } catch (Exception e)
            {

            }

            receiptLoaded = true;
            System.out.println(Thread.currentThread().getName() + " finished");

        }
    }


}



