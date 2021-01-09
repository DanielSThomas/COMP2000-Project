package com.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.time.LocalDate;

public class Payment
{

    private String companyName;
    private LocalDate dateofpurchase;
    private BigDecimal moneyPaid;
    private BigDecimal moneyDue;
    private BigDecimal change;
    private boolean isCashPayment;

    public Payment(BigDecimal newMoneyPaid, BigDecimal newMoneyDue, BigDecimal newChange, boolean isCash)
    {
        companyName = "The One Stop Shop";
        dateofpurchase = LocalDate.now();

        moneyPaid = newMoneyPaid.setScale(2,RoundingMode.HALF_EVEN);
        moneyDue = newMoneyDue.setScale(2,RoundingMode.HALF_EVEN);
        change = newChange.setScale(2,RoundingMode.HALF_EVEN);
        isCashPayment = isCash;
    }


    public String getCompanyName()
    {
        return companyName;
    }

    public LocalDate getDateofpurchase()
    {
        return dateofpurchase;
    }

    public BigDecimal getMoneyPaid()
    {
        return moneyPaid;
    }

    public BigDecimal getMoneyDue()
    {
        return moneyDue;
    }

    public BigDecimal getChange()
    {
        return change;
    }

    public boolean isCashPayment() {
        return isCashPayment;
    }
}
