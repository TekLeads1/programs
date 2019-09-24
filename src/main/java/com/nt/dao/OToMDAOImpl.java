package com.nt.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumber;
import com.nt.domain.User;
import com.nt.utilty.HibernateUtil;

public class OToMDAOImpl implements OtoMDAO {
	private static final String HQL_GET_ALL_USERS_QUERY = "from User";

	public void saveData() {
		Transaction tx = null;
		boolean flag = false;
		Session ses = HibernateUtil.getSession();
		// parent obj
		User user = new User();
		user.setUserId(1001);
		user.setFirstName("raja2");
		// child obj1
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setPhone(7799523281l);
		ph1.setNumberType("office1");
		// child obj1
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setPhone(9876542321l);
		ph2.setNumberType("residence1");
		// set multiple child objs to parent obj(1 to many)
		Set<PhoneNumber> childs = new HashSet<PhoneNumber>();
		childs.add(ph1);
		childs.add(ph2);
		user.setPhones(childs);
		// parent obj
		User user1 = new User();
		user1.setUserId(1002);
		user1.setFirstName("rafi");
		// child object
		PhoneNumber ph3 = new PhoneNumber();
		ph3.setPhone(7777777);
		ph3.setNumberType("office");

		// childs obj1
		PhoneNumber ph4 = new PhoneNumber();
		ph4.setPhone(6666666);
		ph4.setNumberType("residence");
		// set multiple child objs to parent objs(1 to many)
		Set<PhoneNumber> childs1 = new HashSet<PhoneNumber>();
		childs1.add(ph3);
		childs1.add(ph4);
		user1.setPhones(childs1);
		try {
			tx = ses.beginTransaction();
			ses.save(user);
			ses.save(user1);
			flag = true;
		} // try
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag=true) {
				tx.commit();
			} else {
				tx.rollback();
			}
			HibernateUtil.closeSession(ses);
		}
	}

}
