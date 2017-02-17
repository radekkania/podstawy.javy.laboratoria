package pl.lodz.uni.math.dao.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.lodz.uni.math.dao.model.User;

/**
 * Class DaoFactory implements interface DaoFactory. This class is a singleton.
 * 
 * @author radekkania7@wp.pl
 *
 */
public class DaoFactoryImpl implements DaoFactory {

	/**
	 * instance of DaoFactoryImpl
	 */
	private static DaoFactoryImpl instance = new DaoFactoryImpl();
	
	/**
	 * variable source represents type of data source.
	 */
	private DaoFactory source;
	
	/**
	 * Map of source is a helper for method {@link #setSource(EDaoFactory)}
	 * key - EDaoFactory
	 * value - DaoFactoryImpl
	 */
	Map<EDaoFactory,DaoFactory> sourceMap = new HashMap<EDaoFactory,DaoFactory>();
	{
		//init block, initialize values (instances of source type)
		sourceMap.put(EDaoFactory.XML, DaoXML.getInstance());
		sourceMap.put(EDaoFactory.DB, DaoDB.getInstance());
		sourceMap.put(EDaoFactory.WEBSERVICE, DaoWebService.getInstance());
	}

	/**
	 * private constructor, parts of singleton.
	 */
	private DaoFactoryImpl() {}
	
	/**
	 * @return instance of This class.
	 */
	public static DaoFactoryImpl getInstance() {
		return instance;
	}
	
	/**
	 * @param source - type of data source
	 */
	public void setSource(EDaoFactory source) {
		this.source = sourceMap.get(source);
	}
	
	public User selectUserById(int id) {
		return source.selectUserById(id);
	}

	public List<User> selectAllUsers() {
		return source.selectAllUsers();
	}
	
	public String getSourceType() {
		return source.getClass().getName();
	}
}
