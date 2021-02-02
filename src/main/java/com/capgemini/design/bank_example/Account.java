package com.capgemini.design.bank_example;

import com.capgemini.design.bank_example.state.AccountState;
import com.capgemini.design.bank_example.state.Unverified;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;
    private AccountState state = new Unverified();

    public BigDecimal getBalance() {
        return new BigDecimal(balance.unscaledValue(), balance.scale());
    }

    public void deposit(BigDecimal amount) {
        Runnable r = () -> balance = balance.add(amount);
        state = state.deposit(r);
    }

    public void withdrawal(BigDecimal amount) throws IllegalAccessException {
        Runnable r = () -> balance = balance.subtract(amount);
        state = state.withdrawal(r);
    }

    public void close() {
        state = state.close();
    }

    public void verify() {
        state = state.verify();
    }

    public void freeze() throws IllegalAccessException {
        state = state.freeze();
    }

}
