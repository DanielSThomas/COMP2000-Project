package com.model.validation;
import static javax.swing.JOptionPane.showMessageDialog;

public class Authorised implements IState
{

    @Override
    public void ScanCard(Validation validation)
    {

        validation.setState(this);

    }

    @Override
    public void CompletePayment(Validation validation)
    {

        validation.setState(new Unauthorised());

    }

    @Override
    public boolean CurrentState()
    {
        System.out.println("Payment is authorised");

        return true;
    }
}
