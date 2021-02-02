package com.capgemini.design.bank_example.state;

public class Closed implements AccountState{


    @Override
    public AccountState deposit(Runnable r) {
        return this;
    }

    @Override
    public AccountState withdrawal(Runnable r) throws IllegalAccessException {
        return this;
    }

    @Override
    public AccountState verify() {
        return this;
    }

    @Override
    public AccountState freeze() {
        return this;
    }

    @Override
    public AccountState close() {
        return this;
    }
}
