package main;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import pl.lodz.uni.math.dao.factory.DaoFactoryImpl;
import pl.lodz.uni.math.dao.factory.EDaoFactory;

public class Main {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Main.class);
		BasicConfigurator.configure();
		
		DaoFactoryImpl df1 = DaoFactoryImpl.getInstance();
		DaoFactoryImpl df2 = DaoFactoryImpl.getInstance();
		DaoFactoryImpl df3 = DaoFactoryImpl.getInstance();
		
		df1.setSource(EDaoFactory.XML);
		logger.info(df1.getSourceType());
		logger.info(df1.selectAllUsers().size());
		logger.info(df1.selectAllUsers().get(0));
		logger.info(df1.selectUserById(1).getName());
		
		df2.setSource(EDaoFactory.DB);
		logger.info(df1.getSourceType());
		logger.info(df2.getSourceType());
		
		logger.info(df2.selectAllUsers().size());
		logger.info(df2.selectAllUsers().get(0));
		logger.info(df2.selectUserById(1).getName());
		
		df3.setSource(EDaoFactory.WEBSERVICE);
		logger.info(df1.getSourceType());
		logger.info(df2.getSourceType());
		logger.info(df3.getSourceType());
		
		logger.info(df3.selectAllUsers().size());
		logger.info(df3.selectAllUsers().get(0));
		logger.info(df3.selectUserById(1).getName());
	}

}
