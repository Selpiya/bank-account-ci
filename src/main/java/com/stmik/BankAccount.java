package com.stmik;

public class BankAccount {

    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Deposit amount cannot be negative"
            );
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount cannot be negative"
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                    "Withdrawal amount cannot exceed balance"
            );
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}