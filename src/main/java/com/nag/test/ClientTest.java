package com.nag.test;

import com.nt.dao.OToMDAOFactory;
import com.nt.dao.OtoMDAO;
import com.nt.utilty.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		// get dao
		OtoMDAO dao = OToMDAOFactory.getDAO();
		dao.saveData();
		HibernateUtil.closeSessionFactory();
	}

}
