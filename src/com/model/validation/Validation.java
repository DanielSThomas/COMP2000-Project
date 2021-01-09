package com.model.validation;

public class Validation
{
    private IState state;
    public Validation(IState state)
    {
        this.state = state;
    }
    public void setState(IState state)
    {
        this.state = state;
    }
    public void ScanCard()
    {
        state.ScanCard(this);
    }
    public void CompletePayment()
    {
        state.CompletePayment(this);
    }
    public boolean CurrentState()
    {
        return state.CurrentState();
    }



}
