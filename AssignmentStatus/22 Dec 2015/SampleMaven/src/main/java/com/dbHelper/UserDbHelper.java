package com.dbHelper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Repository
public class UserDbHelper {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean insert(User user) {
		Session session = sessionFactory.getCurrentSession();
		int i = (Integer) session.save(user);
		if(i!=0){
			return true;
		}
		else{
			return false;
		}
	}
}
