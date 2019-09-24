package com.nt.dao;
public class OToMDAOFactory {
	public static OtoMDAO getDAO() {
		return new OToMDAOImpl();
		
	}

}
