package pl.lodz.uni.math.bank.transaction;

import pl.lodz.uni.math.bank.client.Client;

public class Deposit extends Transaction {

	public Deposit(Client client, String desc, Double amount) {
		super(client, desc, amount);
	}
}
