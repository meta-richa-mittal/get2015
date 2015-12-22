package com.dbHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Service
@Transactional
public class dbService {
	
	@Autowired
	private UserDbHelper userDbHelper;
	
	public boolean insert(User user) {
		boolean flag = false;
		flag = userDbHelper.insert(user);
		return flag;
	}
}
