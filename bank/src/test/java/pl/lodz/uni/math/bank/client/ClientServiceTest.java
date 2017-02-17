package pl.lodz.uni.math.bank.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ClientServiceTest {
	
	ClientService service;
	Client client;
	
	@Before
	public void setUp() {
		service = ClientService.getInstance();
		client = Mockito.mock(Client.class);
	}
	
	
	@Test
	public void createClientTest() {
		service.createClient("test","Test","12345678990");
		assertNotNull(service.getClientList().get(0));
	}
	
	@Test
	public void removeClientTest() {
		service.addClient(client); 
		assertEquals(2,service.getClientList().size());
		service.removeClient(client); 
		assertEquals(1,service.getClientList().size());
	}

}
