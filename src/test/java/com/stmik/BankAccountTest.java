package com.stmik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount();
    }

    // =========================================================
    // TEST getBalance()
    // =========================================================

    @Test
    public void testInitialBalanceIsZero() {
        // Act
        double balance = account.getBalance();

        // Assert
        assertEquals(0.0, balance, 0.001);
    }

    // =========================================================
    // TEST deposit()
    // =========================================================

    @Test
    public void testDepositValidAmount() {
        // Arrange
        double amount = 100000.0;

        // Act
        account.deposit(amount);

        // Assert
        assertEquals(100000.0, account.getBalance(), 0.001);
    }

    @Test
    public void testMultipleDeposits() {
        // Arrange & Act
        account.deposit(100000.0);
        account.deposit(50000.0);

        // Assert
        assertEquals(150000.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositZero() {
        // Arrange & Act
        account.deposit(0.0);

        // Assert
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositNegativeAmountThrowsException() {
        // Arrange
        double amount = -50000.0;

        // Act
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(amount)
        );

        // Assert
        assertEquals(
                "Deposit amount cannot be negative",
                exception.getMessage()
        );
    }

    // =========================================================
    // TEST withdraw()
    // =========================================================

    @Test
    public void testWithdrawValidAmount() {
        // Arrange
        account.deposit(100000.0);

        // Act
        account.withdraw(40000.0);

        // Assert
        assertEquals(60000.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawEntireBalance() {
        // Arrange
        account.deposit(100000.0);

        // Act
        account.withdraw(100000.0);

        // Assert
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawMoreThanBalanceThrowsException() {
        // Arrange
        account.deposit(50000.0);

        // Act
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(75000.0)
        );

        // Assert
        assertEquals(
                "Withdrawal amount cannot exceed balance",
                exception.getMessage()
        );
    }

    @Test
    public void testWithdrawNegativeAmountThrowsException() {
        // Arrange
        account.deposit(100000.0);

        // Act
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(-10000.0)
        );

        // Assert
        assertEquals(
                "Withdrawal amount cannot be negative",
                exception.getMessage()
        );
    }
}