package pl.lodz.uni.math.dao.factory;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

import pl.lodz.uni.math.dao.model.User;

public class DaoDB implements DaoFactory {
	
	private static DaoFactory instance = new DaoDB();
	
	private User user;
	
	private List<User> usersList;
	
	private DaoDB() {}

	public User selectUserById(int id) {
		user = Mockito.mock(User.class);
		Mockito.when(user.getId()).thenReturn(id);
		Mockito.when(user.getName()).thenReturn("userDataBase");
		return user;
	}

	public List<User> selectAllUsers() {
		usersList = Mockito.mock(ArrayList.class);
		user = Mockito.mock(User.class);
		Mockito.when(usersList.get(0)).thenReturn(user);
		Mockito.when(usersList.size()).thenReturn(1);
		return usersList;
	}

	public static DaoFactory getInstance() {
		return instance;
	}

}
