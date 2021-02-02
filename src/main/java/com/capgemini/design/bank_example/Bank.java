package com.capgemini.design.bank_example;

import java.math.BigDecimal;

public class Bank {

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(BigDecimal.valueOf(10000));
        try {
            account.withdrawal(BigDecimal.valueOf(1000));
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        System.out.printf("account balance is: %s%n",account.getBalance().toString());  //10.000
        account.verify();
        try {
            account.withdrawal(BigDecimal.valueOf(1000));
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        System.out.printf("account balance is: %s%n",account.getBalance().toString());  // 9.000
        account.deposit(BigDecimal.valueOf(1000));
        System.out.printf("account balance is: %s%n",account.getBalance().toString());  //10.000
        try {
            account.freeze();
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        System.out.printf("account balance is: %s%n",account.getBalance().toString());  //10.000
        account.close();
        System.out.printf("account balance is: %s%n",account.getBalance().toString());  //10.000
        try {
            account.withdrawal(BigDecimal.valueOf(1000));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.printf("account balance is: %s%n",account.getBalance().toString());  //10.000
    }
}
