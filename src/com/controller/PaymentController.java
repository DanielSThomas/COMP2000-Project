package com.controller;

import com.model.CashPayment;
import com.model.Database;

import javax.swing.*;
import java.text.DecimalFormat;

public class PaymentController
{

    public double cashAdded;
    public double cashDue;
    public double change;


    public void CalculateCash(JTextField input, JLabel output)
    {
        DecimalFormat decimalFormat = new DecimalFormat("##.00");

        cashDue = Database.getInstance().basketTotal;

        cashAdded += Double.parseDouble(input.getText());

        output.setText("Amount Paid : £" +  Double.parseDouble(decimalFormat.format(cashAdded)));
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
        Database.getInstance().cashPayment = new CashPayment(cashAdded, cashDue, change);
    }



}
