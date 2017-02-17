package pl.lodz.uni.math.dao.factory;

import java.util.List;

import pl.lodz.uni.math.dao.model.User;

/**
 * Interface DaoFactory has a set of a possible method.
 * 
 * @author radekkania7@wp.pl
 */
public interface DaoFactory {
	
	/**
	 * @param ID of User.
	 * @return instance of User.
	 */
	public User selectUserById(int id);
	
	/**
	 * @return list of all users from selected data source.
	 */
	public List<User> selectAllUsers();
	
}
