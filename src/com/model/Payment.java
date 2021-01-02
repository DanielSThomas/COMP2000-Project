package com.model;


import java.util.ArrayList;
import java.time.LocalDate;

public class Payment //Might be useless
{

    private String companyName;
    private LocalDate dateofpurchase;
    private double moneyPaid;
    private double moneyDue;
    private double change;
    private boolean isCashPayment;

    public Payment(double newMoneyPaid, double newMoneyDue, double newChange, boolean isCash)
    {
        companyName = "The One Stop Shop";
        dateofpurchase = LocalDate.now();

        moneyPaid = newMoneyPaid;
        moneyDue = newMoneyDue;
        change = newChange;
        isCashPayment = isCash;
    }

    public String getAllPaymentInfoCash()
    {
        String _string = new String( companyName + "/n" + dateofpurchase + "/n" + moneyDue + "/n" + change + "/n" + "Cash Payment" );
        return _string;
    }


    public String getCompanyName()
    {
        return companyName;
    }

    public LocalDate getDateofpurchase()
    {
        return dateofpurchase;
    }

    public double getMoneyPaid()
    {
        return moneyPaid;
    }

    public double getMoneyDue()
    {
        return moneyDue;
    }

    public double getChange()
    {
        return change;
    }

    public boolean isCashPayment() {
        return isCashPayment;
    }
}
