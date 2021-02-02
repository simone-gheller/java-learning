package com.capgemini.design.bank_example.state;

import java.util.function.Consumer;

public interface AccountState {

    public AccountState deposit(Runnable r);
    public AccountState withdrawal(Runnable r) throws IllegalAccessException;
    public AccountState verify();
    public AccountState freeze() throws IllegalAccessException;
    public AccountState close();

}
