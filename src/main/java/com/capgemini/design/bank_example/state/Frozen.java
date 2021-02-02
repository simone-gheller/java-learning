package com.capgemini.design.bank_example.state;

public class Frozen implements AccountState{


    @Override
    public AccountState deposit(Runnable r) {
        r.run();
        return new Active();
    }

    @Override
    public AccountState withdrawal(Runnable r) throws IllegalAccessException {
        r.run();
        return new Active();
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
        return new Closed();
    }
}
