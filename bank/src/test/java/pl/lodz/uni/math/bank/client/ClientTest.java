package pl.lodz.uni.math.bank.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import pl.lodz.uni.math.bank.account.Account;

public class ClientTest {
	
	Client client;
	
	Account account;
	
	@Before
	public void setUp() {
		account = Mockito.mock(Account.class);
	}
	
	@Test
	public void clientTest() {
		client = new Client("name", "surname", "12345678901");
		client.addAccount(account);
		assertNotNull(client);
		assertNotNull(client.getAccountList());
		client.upCountOfWire();
		assertEquals(2,client.getCountOfWire());
		client.toString();
		
	}

}
