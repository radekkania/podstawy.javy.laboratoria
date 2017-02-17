package pl.lodz.uni.math.bank.bank;

import java.util.List;

import pl.lodz.uni.math.bank.account.Account;
import pl.lodz.uni.math.bank.client.Client;
import pl.lodz.uni.math.bank.transaction.Transaction;

public interface Bank {
	
	public void createAccount(String description, Client client);
	
	public void createClient(String name, String surname, String pesel);
	
	public void removeClient(Client client);
	
	public void removeAccount(Account account);
			
	public List<Account> getAccountList();
	
	public List<Client> getClientList();
	
	public List<Transaction> getHistoryByAccount(Account account);

}
