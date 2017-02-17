package pl.lodz.uni.math.bank.bank;

import java.util.List;

import pl.lodz.uni.math.bank.account.Account;
import pl.lodz.uni.math.bank.account.AccountService;
import pl.lodz.uni.math.bank.client.Client;
import pl.lodz.uni.math.bank.client.ClientService;
import pl.lodz.uni.math.bank.transaction.Transaction;


/**
 * Class represents a Bank.
 * 
 * @author radekkania7@wp.pl
 *
 */
public class BankImpl implements Bank {
	 
	private AccountService accountService = AccountService.getIntance();
	
	private ClientService clientService = ClientService.getInstance();
				  
	public void createAccount(String description, Client client) {
		accountService.createAccount(description, client); 
	}
	
	public void createClient(String name, String surname, String pesel) {
		clientService.createClient(name,surname,pesel);
	}
	
	public void removeClient(Client client) {
		clientService.removeClient(client);
	}
	
	public void removeAccount(Account account) {
		accountService.removeAccount(account);
	}
			
	public List<Account> getAccountList() {
		return accountService.getAccountList();
	}
	
	public List<Client> getClientList() {
		return clientService.getClientList();
	}
	
	public List<Transaction> getHistoryByAccount(Account account) {
		return accountService.getHistoryByAccount(account);
	}
}
