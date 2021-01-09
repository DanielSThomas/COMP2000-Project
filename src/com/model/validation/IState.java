package com.model.validation;

public interface IState
{
    public void ScanCard(Validation validation);
    public void CompletePayment(Validation validation);
    public boolean CurrentState();
}
