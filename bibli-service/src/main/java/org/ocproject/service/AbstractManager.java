package org.ocproject.service;

import org.ocproject.dao.DaoFactory;


public abstract class AbstractManager {
	
	private static DaoFactory daoFactory;

	protected static DaoFactory getDaoFactory() {
		return daoFactory;
	}

	protected static void setDaoFactory(DaoFactory daoFactory) {
		AbstractManager.daoFactory = daoFactory;
	}
	

}
