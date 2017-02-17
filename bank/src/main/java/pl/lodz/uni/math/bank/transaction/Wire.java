package pl.lodz.uni.math.bank.transaction;

import pl.lodz.uni.math.bank.account.Account;
import pl.lodz.uni.math.bank.client.Client;


public class Wire extends Transaction {
	
	Boolean isSwift;
	
	String country;
	
	Account toAccount;

	public Wire(Client client, Account toAccount, Boolean isSwift, String country, String desc, Double amount) {
		super(client, desc, amount);
		this.toAccount = toAccount;
		this.isSwift = isSwift;
		this.country = country;
	}

}
