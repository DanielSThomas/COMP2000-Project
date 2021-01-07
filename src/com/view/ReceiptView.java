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
    private Thread thread2;


    private PanelOneThread panelOneThread;
    private PanelTwoThread panelTwoThread;

    public boolean waiting = true;



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
                guiController.InitialiseGui();
                guiController.ChangePage(receiptView, guiController.kioskView);

            }
        });

        btnPrint.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                panelOneThread = new PanelOneThread();
                thread1 = new Thread(panelOneThread);

                panelTwoThread = new PanelTwoThread();
                thread2 = new Thread(panelTwoThread);

                thread1.start();
                thread2.start();

                waiting = false;

                paymentController.CalculateRecipt(lstReceipt, defaultListModel);


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
                System.out.println(Thread.currentThread().getName() + " is waiting");
                while (waiting == true)
                {
                    Thread.sleep(1000);
                }
            } catch (Exception e)
            {

            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }

    public class PanelTwoThread implements Runnable
    {
        public void run()
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " is waiting");
                thread1.join();

                lstReceipt.setModel(defaultListModel);
            }
            catch(Exception e)
            {

            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }

}



