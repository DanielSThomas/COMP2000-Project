package com.controller;

import com.model.Database;
import com.model.Payment;
import com.model.StockType;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

public class PaymentController
{

    public BigDecimal cashAdded = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
    public BigDecimal cashDue = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
    public BigDecimal change = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
    public boolean isCash;


    public void CalculateCash(JTextField input, JLabel output)
    {

        cashDue = Database.getInstance().basketTotal;

        cashAdded = cashAdded.add(new BigDecimal(input.getText()));

        output.setText("Amount Paid : £" +  cashAdded);

        isCash = true;

    }

    public void CardValidation(boolean isValid)
    {
        isCash = false;

        if (isValid == true)
        {

            cashDue = Database.getInstance().basketTotal;

            showMessageDialog(null, "Payment Accepted");

        }
        else
        {
            showMessageDialog(null, "!Card Payment Failed!. Please try again or use another payment method.");

        }




    }

    public BigDecimal CalculateChange()
    {

        DecimalFormat decimalFormat = new DecimalFormat("##.00");

        change = cashAdded.subtract(cashDue.setScale(2,RoundingMode.HALF_EVEN));

        if (change.doubleValue() > 0.0)
        {
            return change;
        }

        return new BigDecimal("0.00");

    }

    public void StorePaymentDetails()
    {
        Database.getInstance().payment = new Payment(cashAdded, cashDue, change, isCash);
    }

    public void CalculateRecipt(JList jList,DefaultListModel defaultListModel)
    {
        String paymentInfo;
        ArrayList<StockType> boughtItems;

            defaultListModel.clear();

            defaultListModel.add(defaultListModel.getSize(),Database.getInstance().payment.getCompanyName());
            defaultListModel.add(defaultListModel.getSize(),Database.getInstance().payment.getDateofpurchase());
            defaultListModel.add(defaultListModel.getSize(), "Total Cost : £" + Database.getInstance().payment.getMoneyDue());

            if (Database.getInstance().payment.isCashPayment() == true)
            {
                defaultListModel.add(defaultListModel.getSize(), "Change : £" + Database.getInstance().payment.getChange());
                defaultListModel.add(defaultListModel.getSize(),"Cash Payment");
            }
            else
            {
                defaultListModel.add(defaultListModel.getSize(), "Card Payment");
            }

            defaultListModel.add(defaultListModel.getSize(),"-----Items Bought-----");

            for (int i = 0; i < Database.getInstance().basket.size(); i++)
            {
                defaultListModel.add(defaultListModel.getSize(),Database.getInstance().basket.get(i).getBasketInfo());
            }

          //  jList.setModel(defaultListModel);


    }

}
