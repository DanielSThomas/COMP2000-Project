package com.controller;

import com.model.Database;

import javax.swing.*;
import java.text.DecimalFormat;

public class PaymentController
{

    double cashAdded;
    double cashDue;
    double change;


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



}
