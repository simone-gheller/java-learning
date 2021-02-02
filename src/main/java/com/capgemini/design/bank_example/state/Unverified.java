package com.capgemini.design.bank_example.state;

public class Unverified implements AccountState{

    @Override
    public AccountState deposit(Runnable r) {
        r.run();
        return this;
    }

    @Override
    public AccountState withdrawal(Runnable r) throws IllegalAccessException {
        throw new IllegalAccessException("Can't withdraw when account isn't verified");
    }

    @Override
    public AccountState verify() {
        return new Active();
    }

    @Override
    public AccountState freeze() throws IllegalAccessException {
        throw new IllegalAccessException("Can't freeze when account isn't verified");
    }

    @Override
    public AccountState close() {
        return new Closed();
    }
}
