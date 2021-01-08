package com.view;

import com.controller.GUIController;
import com.controller.PaymentController;
import com.model.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptView extends JFrame
{
    private JButton btnPrint;
    private JButton btnFinish;
    private JList lstReceipt;
    private JPanel receiptPanel;

    private ReceiptView receiptView;
    private PaymentController paymentController;

    private DefaultListModel defaultListModel;

    private Thread thread1;

    private PanelOneThread panelOneThread;



    public boolean receiptLoaded = false;



    public ReceiptView()
    {
        receiptView = this;

        GUIController guiController = new GUIController();
        receiptView.setContentPane(receiptPanel);
        receiptView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        receiptView.setPreferredSize(new Dimension(500,500));
        paymentController = new PaymentController();
        defaultListModel = new DefaultListModel();


        receiptView.pack();
        

        btnFinish.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Database.getInstance().basket.clear();
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
                    panelOneThread = new PanelOneThread();
                    thread1 = new Thread(panelOneThread);

                    thread1.start();

                }

            }
        });
    }


    public class PanelOneThread implements Runnable
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



