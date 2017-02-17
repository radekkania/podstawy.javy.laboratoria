package pl.lodz.uni.math.bank.account;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import pl.lodz.uni.math.bank.client.Client;
import pl.lodz.uni.math.bank.transaction.Transaction;

public class AccountServiceTest {
	
	AccountService accountService;
	
	Client client;
	
	Account account;
	
	@Before
	public void setUp() {
		accountService = AccountService.getIntance();
		client = Mockito.mock(Client.class);
		account = Mockito.mock(Account.class); 
	}
	
	@Test
	public void createAccountTest() {
		accountService.createAccount("konto", client);
		
	}
	
	@Test
	public void removeAccountTest() {
		accountService.createAccount("konto", client);
		accountService.removeAccount(accountService.getAccountList().get(0));
	}
	
	public void getAccountListTest() {
		List<Account> list = accountService.getAccountList();
		assertNotNull(list);
	}
	
	@Test
	public void getTransactionListTest() {
		Mockito.when(account.getListOfTransaction()).thenReturn(new ArrayList<Transaction>());
		List<Transaction> list = accountService.getHistoryByAccount(account);
		assertNotNull(list);
	} 
	
}
