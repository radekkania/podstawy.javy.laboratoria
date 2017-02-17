package pl.lodz.uni.math.bank.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class ClientService {
	
	Logger logger = Logger.getLogger(ClientService.class);
	
	{
		BasicConfigurator.configure();
	} 
	
	private static ClientService instance = new ClientService();
	
	private ClientService() {}
	 
	private List<Client> listOfCilient = new ArrayList<Client>();
	
	public void createClient(String name, String surname, String pesel) {
		try {
			Client client = new Client(name,surname,pesel);
			listOfCilient.add(client);
			if (logger.isInfoEnabled()) {
				logger.info(client.toString() + " created succesfully");
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Error ocurred during creating new Client", e);
			}
		}
	} 
	
	public void removeClient(Client client) {
		try {
			listOfCilient.remove(client);
			logger.info("client removed");
		} catch (Exception e) {
			logger.info("client removed fail");
		}
	}
	
	public void addClient(Client client) {
		listOfCilient.add(client);
	}
	
	public List<Client> getClientList() {
		return listOfCilient;
	}
	
	public static ClientService getInstance() {
		return instance;
	}

}
