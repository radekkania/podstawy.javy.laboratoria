package pl.lodz.uni.math.bank.client;

import java.util.ArrayList;
import java.util.List;

import pl.lodz.uni.math.bank.account.Account;

/**
 * Class represents a Client of a Bank.
 * 
 * @author radekkania7@wp.pl
 *  
 */
public class Client {
	
	private String name;
	
	private String surname;
	
	/**
	 * Length of a pesel must equal 11.
	 */ 
	private String pesel;
			
	/**
	 * Each client can have more than one account.
	 */
	private List<Account> listOfClientAccount = new ArrayList<Account>(); 
	 
	private int countOfWire = 1;
	
	public Client(String name, String surname, String pesel) {
		this.name = name;
		this.surname = surname;
		this.pesel = pesel;
	}
	
	public void addAccount(Account account) {
		listOfClientAccount.add(account);
	}
	
	public List<Account> getAccountList() {
		return listOfClientAccount;
	}
	
	public void upCountOfWire() {
		countOfWire++;
	}
	
	public int getCountOfWire() {
		return countOfWire;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", surname=" + surname + ", pesel=" + pesel  + "]";
	}
		
}
