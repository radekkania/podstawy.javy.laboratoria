package pl.lodz.uni.math.bank.transaction;

import pl.lodz.uni.math.bank.account.Account;
import pl.lodz.uni.math.bank.client.Client;

public class Check extends Transaction {
	
	Account fromAccount;

	public Check(Account from, Client client, String desc, Double amount) {
		super(client, desc, amount);
		this.fromAccount = from;
	}
	
}
