package com.model.validation;
import static javax.swing.JOptionPane.showMessageDialog;

public class Unauthorised implements IState
{

    @Override
    public void ScanCard(Validation validation)
    {
        validation.setState(new Authorised());
    }

    @Override
    public void CompletePayment(Validation validation)
    {

        validation.setState(this);



    }

    @Override
    public boolean CurrentState()
    {
        System.out.println("Payment is not authorised");

        return false;
    }

}
