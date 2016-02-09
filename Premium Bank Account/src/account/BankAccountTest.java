package account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.AccountOverdrawnException;
import exceptions.InsufficientFundsException;
import exceptions.InvalidTransactionException;

import org.junit.After;

public class BankAccountTest {

	private BankAccount account1;
	private BankAccount account2;
	private BankAccount account3;

	@Before
	public void setUp() throws Exception {
		account1 = new BankAccount();
		account2 = new BankAccount(600.0);
	}

	@After
	public void tearDown() throws Exception {
		account1 = null;
		account2 = null;
	}

	@Test(expected = AccountOverdrawnException.class)
	public void testAccountCreation_03() throws AccountOverdrawnException {

		account3 = new BankAccount(49.99);
	}

	@Test
	public void testBankAccount() {
		assertEquals("balance", 50.0, account1.getBalance(), 0);
	}

	@Test
	public void testBankAccountDouble() {
		assertEquals("balance", 600.0, account2.getBalance(), 0);
	}

	@Test
	public void testDeposit() throws InvalidTransactionException {
		account1.deposit(100.00);
		assertEquals("balance", 150.0, account1.getBalance(), 0);
	}

	@Test(expected = InvalidTransactionException.class)
	public void testDeposit2() throws InvalidTransactionException {
		account2.deposit(-20.00);
	}

	@Test
	public void testWithdraw() throws InsufficientFundsException {
		account2.withdraw(100.00);
		assertEquals("balance", 500.0, account2.getBalance(), 0);
	}

	@Test(expected = InsufficientFundsException.class)
	public void testWithdraw2() throws InsufficientFundsException {
		account1.withdraw(0.01);
	}

	@Test
	public void testTransfer() throws InvalidTransactionException, InsufficientFundsException {
		account2.transfer(450.0, account1);
		assertEquals("balance", 500.0, account1.getBalance(), 0);
		assertEquals("balance", 150.0, account2.getBalance(), 0);
	}

	@Test(expected = InsufficientFundsException.class)
	public void testBadTrsnfer() throws InvalidTransactionException, InsufficientFundsException {
		account1.transfer(0.01, account2);
	}

	@Test
	public void testIsNotPremiumAccount() {
		assertFalse("balance", account1.isPremiumAccount());
	}

	@Test
	public void testIsPremiumAccount() {
		assertTrue("balance", account2.isPremiumAccount());
	}

	@Test
	public void testGetBalance() {
		assertEquals("balance", 50.0, account1.getBalance(), 0);
	}

}
