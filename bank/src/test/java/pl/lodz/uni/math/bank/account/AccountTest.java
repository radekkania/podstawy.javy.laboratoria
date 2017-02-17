package pl.lodz.uni.math.bank.account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import pl.lodz.uni.math.bank.client.Client;
import pl.lodz.uni.math.bank.transaction.Deposit;
import pl.lodz.uni.math.bank.transaction.Transaction;



public class AccountTest {
	
	Account account, account2;
	
	Client client; 
	
	Transaction transaction;
	
	@Before
	public void setUp() {
		client = Mockito.mock(Client.class);
		account = new Account("Konto kotno");
		account2 = new Account("konto dwa");
		transaction = Mockito.mock(Deposit.class);
	}
	
	@Test
	public void depositTest() {
		account.deposit(client, "depozyt", 200.0);
		assertEquals((Double) 200.0, account.getBallance()); 
	}
	
	@Test
	public void checkTest() {
		account.check(account2, client, "check test", 400.0);
		account2.upBallance(200.0);
		account.check(account2, client, "check test 2", 100.0); 
	}
	
	@Test
	public void wireTest() {
		Mockito.when(client.getCountOfWire()).thenReturn(1); 
		Mockito.when(client.toString()).thenReturn("Test");
		account.wireOut(client, account2, false, "PL", "przelew", 200.0); 
		
		account.upBallance(200.0);
		account.wireOut(client, account2, true, "LT", "przelewik", 100.0);
	}
	
	@Test
	public void addClientTest() {
		account.addClient(client);
		assertNotNull(account.getClientList());
		assertEquals(account.getClientList().get(0),client);
	}
	
	@Test
	public void generateNumberTest() {
		assertNotNull(account.getAccountNumber());
		assertEquals(account.getAccountNumber().length(), 15);
	}

}
