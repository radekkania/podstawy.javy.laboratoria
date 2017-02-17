package pl.lodz.uni.math.bank.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import pl.lodz.uni.math.bank.account.Account;
import pl.lodz.uni.math.bank.bank.BankImpl;
import pl.lodz.uni.math.bank.client.Client;
import pl.lodz.uni.math.bank.client.ClientService;

public class MainTest {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(ClientService.class);
		BasicConfigurator.configure(); 
		
		BankImpl bank = new BankImpl();
		bank.createClient("Radosny", "Rado", "95051004035"); 
		bank.createClient("krzysztof", "Jarzyna", "95051004333");
		
		Client client1 = bank.getClientList().get(0);
  		Client client2 = bank.getClientList().get(1);
		bank.createAccount("Konto rados³awa pierwsze", client1);
		bank.createAccount("heheh elo", client2);
		
		Account account = bank.getAccountList().get(0);
		Account account2 = bank.getAccountList().get(1); 
		account.deposit(client1, "przelew elo", 200.0);
		account.deposit(client1, "na waciki", 20000.0);
		
		logger.info("pierwsze sprawdzenie");
		logger.info(account.getBallance());
		logger.info(account2.getBallance());
	
		account.wireOut(client1, account2, true, "PL", "przelewik krajowy", 100.0);
		
		logger.info("drugie sprawdzenie");
		logger.info(account.getBallance());
		logger.info(account2.getBallance());
		
		account.wireOut(client1, account2, true, "PL", "przelewik krajowy", 2000.0);
		
		logger.info("trzecie sprawdzenie");
		logger.info(account.getBallance());
		logger.info(account2.getBallance()); 
		
		
		account2.check(account, client2, "wykonanie checku", 500.0);
		
		logger.info("czwarte sprawdzenie");
		logger.info(account.getBallance());
		logger.info(account2.getBallance());
		
		logger.info("iloœæ klientów: " + bank.getClientList().size());
		bank.createClient("blals", "hehe", "9505100341");
		logger.info("iloœæ klientów: " + bank.getClientList().size());
		
		logger.info("iloœæ kont: " + bank.getAccountList().size());
		bank.createAccount("konto", bank.getClientList().get(2));
		logger.info("iloœæ kont: " + bank.getAccountList().size());
		
		bank.removeAccount(account2);
		bank.removeClient(client1);
		
		logger.info("iloœæ klientów: " + bank.getAccountList().size());
		logger.info("iloœæ kont: " + bank.getAccountList().size());
		
		logger.info(bank.getAccountList().size());
		logger.info(bank.getClientList().size());
		
		logger.info(bank.getHistoryByAccount(account));
		
		

	}

}
