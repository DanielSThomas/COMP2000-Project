package com.controller;

import com.model.validation.IState;
import com.model.validation.Unauthorised;
import com.model.validation.Validation;
import static javax.swing.JOptionPane.showMessageDialog;

public class ValidationController
{
    private IState startingState;

    public Validation validation;

    public void Initialise()
    {
        startingState = new Unauthorised();
        validation = new Validation(startingState);
    }


    public void AuthoriseCard(boolean isCardValid)
    {
        if(isCardValid == true)
        {
            showMessageDialog(null, "Payment Accepted, please proceed.");
            validation.ScanCard();
        }
        else
        {
            showMessageDialog(null, "Payment Failed! Please try again or use another payment method.");
        }
    }

    public boolean CompletePayment()
    {
        if (validation.CurrentState() == true)
        {
            validation.CompletePayment();
            return true;
        }
        else
        {
            validation.CompletePayment();
            return false;
        }
    }




}
