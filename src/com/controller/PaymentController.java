package com.controller;

import com.model.Database;
import com.model.Payment;
import com.model.StockType;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PaymentController
{

    public double cashAdded;
    public double cashDue;
    public double change;
    public boolean isCash;


    public void CalculateCash(JTextField input, JLabel output)
    {
        DecimalFormat decimalFormat = new DecimalFormat("##.00");

        cashDue = Database.getInstance().basketTotal;

        cashAdded += Double.parseDouble(input.getText());

        output.setText("Amount Paid : £" +  Double.parseDouble(decimalFormat.format(cashAdded)));

        isCash = true;
    }

    public double CalculateChange()
    {
        DecimalFormat decimalFormat = new DecimalFormat("##.00");

        change = cashAdded - cashDue;

        if (change > 0.0)
        {
            return Double.parseDouble(decimalFormat.format(change));
        }
        return 0.0;
    }

    public void StorePaymentDetails()
    {
        Database.getInstance().payment = new Payment(cashAdded, cashDue, change, isCash);
    }

    public void CalculateRecipt(JList jList,DefaultListModel defaultListModel)
    {
        String paymentInfo;
        ArrayList<StockType> boughtItems;

        if (Database.getInstance().payment.isCashPayment() == true)
        {
            paymentInfo = Database.getInstance().payment.getAllPaymentInfoCash();

            defaultListModel.clear();

            defaultListModel.add(defaultListModel.getSize(),Database.getInstance().payment.getCompanyName());
            defaultListModel.add(defaultListModel.getSize(),Database.getInstance().payment.getDateofpurchase());
            defaultListModel.add(defaultListModel.getSize(), "Total Cost : £" + Database.getInstance().payment.getMoneyDue());
            defaultListModel.add(defaultListModel.getSize(), "Change : £" + Database.getInstance().payment.getChange());
            defaultListModel.add(defaultListModel.getSize(),"Cash Payment");
            defaultListModel.add(defaultListModel.getSize(),"-----Items Bought-----");

            for (int i = 0; i < Database.getInstance().basket.size(); i++)
            {
                defaultListModel.add(defaultListModel.getSize(),Database.getInstance().basket.get(i).getAllInfo());
            }



            jList.setModel(defaultListModel);
        }





    }



}
