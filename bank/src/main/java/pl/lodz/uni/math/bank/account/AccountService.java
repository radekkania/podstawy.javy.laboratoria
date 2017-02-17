package pl.lodz.uni.math.bank.account;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import pl.lodz.uni.math.bank.client.Client;
import pl.lodz.uni.math.bank.transaction.Transaction;

/**
 * Class AccountService represents something like repository with accounts.
 * It is a singleton. Need only one instance in whole project.
 * 
 * @author radekkania7@wp.pl
 *
 */
public class AccountService {
	
	Logger logger = Logger.getLogger(AccountService.class);
	
	{ 
		BasicConfigurator.configure();
	}
	
	private static AccountService instance = new AccountService();
			
	private AccountService() {} 
		
	private List<Account> listOfAccount = new ArrayList<Account>();
		
	public void createAccount(String description, Client client) {	
		try { 
			Account account = new Account(description);
			listOfAccount.add(account);
			account.addClient(client);
			if (logger.isInfoEnabled()) {
				logger.info(account.toString() + " created succesfully");
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Error ocurred during creating new Account", e);
			}
		}
	} 
	
	public void removeAccount(Account account) {
		try {
			listOfAccount.remove(account);
			logger.info("Account removed");
		} catch (Exception e) {
			logger.info("Fail Account removed");
		}
	}
			
	public List<Account> getAccountList() {
		return listOfAccount;
	}
	
	public List<Transaction> getHistoryByAccount(Account account) {
		return account.getListOfTransaction();
	}
	
	public static AccountService getIntance() {
		return instance;
	}
	
}
