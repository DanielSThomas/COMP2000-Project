package com.model;


import java.util.ArrayList;

public class CashPayment //Might be useless
{

    private double cashAdded;
    private double cashDue;
    private double change;

    public CashPayment(double newCashAdded, double newCashDue, double newChange)
    {
        cashAdded = newCashAdded;
        cashDue = newCashDue;
        change = newChange;
    }

    public double getCashAdded()
    {
        return cashAdded;
    }

    public double getCashDue()
    {
        return cashDue;
    }

    public double getChange()
    {
        return change;
    }
}
