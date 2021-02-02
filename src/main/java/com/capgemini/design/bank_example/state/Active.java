package com.capgemini.design.bank_example.state;

public class Active implements AccountState{

    @Override
    public AccountState deposit(Runnable r) {
        r.run();
        return this;
    }

    @Override
    public AccountState withdrawal(Runnable r) throws IllegalAccessException {
        r.run();
        return this;
    }

    @Override
    public AccountState verify() {
        return this;
    }

    @Override
    public AccountState freeze() {
        return new Frozen();
    }

    @Override
    public AccountState close() {
        return new Closed();
    }
}
