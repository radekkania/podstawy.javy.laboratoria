package pl.lodz.uni.math.bank.transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import pl.lodz.uni.math.bank.account.Account;
import pl.lodz.uni.math.bank.client.Client;

/**
 * 
 * @author radekkania7@wp.pl
 *
 */
public abstract class Transaction {
	
	private int transactionNumber; 
	
	private String dateOfTransactionDone;
	
	private String description;
	
	private Client client;
	
	private Double amount;
	
	public Transaction(Client client, String desc, Double amount) {
		this.client = client;
		this.description = desc;
		this.dateOfTransactionDone = getCurrentTime();
		this.amount = amount;
	}
	
	public void setNumberOfTransaction(int number) {
		this.transactionNumber = number;
	}
		
	private String getCurrentTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}
	
	public String getTime() {
		return dateOfTransactionDone;
	}

	@Override
	public String toString() {
		return  this.getClass().getName() + " [transactionNumber=" + transactionNumber + ", dateOfTransactionDone="
				+ dateOfTransactionDone + ", description=" + description + ", client=" + client + ", amount=" + amount
				+ "]";
	}
	
}
