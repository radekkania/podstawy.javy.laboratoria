package pl.lodz.uni.math.bank.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import pl.lodz.uni.math.bank.client.Client;
import pl.lodz.uni.math.bank.transaction.Check;
import pl.lodz.uni.math.bank.transaction.Deposit;
import pl.lodz.uni.math.bank.transaction.Transaction;
import pl.lodz.uni.math.bank.transaction.Wire;

/**
 * This class represents Bank Account.
 * 
 * @author radekkania7@wp.pl
 *
 */
public class Account {
	
	Logger logger = Logger.getLogger(Account.class);
	{ 
		BasicConfigurator.configure();
	}   
	
	private List<Transaction> listOfTransaction = new ArrayList<Transaction>();	
	private List<Client> listOfClient = new ArrayList<Client>();
	private String description;
	private String numberOfAccount;
	private Double ballance = 0.0;
	private int depositNumber = 1;
	private int checkNumber = 1;
	
	public void deposit(Client client, String desc, double amount) {
		if (logger.isInfoEnabled()) { 
			logger.info("Start deposit transaction number: " + depositNumber
					+ " for: " + this.toString() 
					+  " for: " + client.toString());
		}
		try {
			Deposit deposit = new Deposit(client,desc,amount);
			this.upBallance(amount);
			this.listOfTransaction.add(deposit);
			deposit.setNumberOfTransaction(depositNumber);
			this.depositNumber += 1;
			if (logger.isInfoEnabled()) {
				if (logger.isInfoEnabled()) {
					logger.info("Transaction done at: " + deposit.getTime());
				}	
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Transaction fail", e);
			}
		}
	}
	
	public void wireOut(Client clientFrom, Account toAccount, Boolean isSwift, String country, String desc, Double amount) {
		if (logger.isInfoEnabled()) {
			logger.info("Start Wire transaction number: " + clientFrom.getCountOfWire() 
					+ " from: " + this.numberOfAccount
					+  " for: " + clientFrom.toString() + " to " + toAccount.getAccountNumber());
		}
		try { 
			Wire wire = new Wire(clientFrom, toAccount, isSwift, country, desc, amount);
			if (this.ballance > amount) {
				int transactionNumber = clientFrom.getCountOfWire();
				wire.setNumberOfTransaction(transactionNumber);
				clientFrom.upCountOfWire();
				this.downBallance(amount);
				toAccount.upBallance(amount);
				this.listOfTransaction.add(wire);
				if (logger.isInfoEnabled()) {
					logger.info("Transaction done at: " + wire.getTime());
				}
				
			} else {
				if (logger.isInfoEnabled()) {
					logger.info("Not enough money to do this wire");
				}
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Transaction fail", e);
			}
		}
	
	}
	
	public void check(Account fromAccount, Client client, String desc, Double amount) {
		if (logger.isInfoEnabled()) {
			logger.info("Start check transaction number: " + checkNumber
					+ " from: " + fromAccount.generateNumberOfAccount()
					+  " to: " + this.getAccountNumber());
		}
		
		try {
			Check check = new Check(fromAccount, client, desc, amount);
			check.setNumberOfTransaction(checkNumber);
			checkNumber += 1;
			if (fromAccount.getBallance() > amount) {
				fromAccount.downBallance(amount);
				this.upBallance(amount);
				logger.info("Transaction done at: " + check.getTime());
			} else {
				logger.info("Not enough money, cant do check");
			}
		} catch (Exception e) {
			
		}
	}
	
	public Account(String desc) {
		this.description = desc;
		numberOfAccount = generateNumberOfAccount();
	}
	
	private String generateNumberOfAccount() {
		StringBuffer accountNumber = new StringBuffer();
		Random generator = new Random();
		for (int i = 0; i < 15; i++) {
			accountNumber.append(generator.nextInt(10));
		}
		return accountNumber.toString();
	}
	
	public void addClient(Client client) {
		this.listOfClient.add(client);
	}
	
	public List<Client> getClientList() {
		return listOfClient;
	}
			
	public List<Transaction> getListOfTransaction() {
		return listOfTransaction;
	}
	
	public void upBallance(Double amount) {
		this.ballance += amount;
	}
	
	public void downBallance(Double amount) {
		this.ballance -= amount;
	}
	
	public String getAccountNumber() {
		return numberOfAccount;
	}
	
	public Double getBallance() {
		return this.ballance;
	}

	@Override
	public String toString() {
		return "Account [description=" + description + ", numberOfAccount=" + numberOfAccount + "]";
	}
}
