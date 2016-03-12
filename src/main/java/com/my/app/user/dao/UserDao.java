package com.my.app.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.my.app.user.domain.QTUser;
import com.my.app.user.domain.TUser;
import com.mysema.query.jpa.impl.JPAQuery;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private JPAQuery query = new JPAQuery(entityManager);
	
	public List<TUser> getUserList() {
		QTUser tuser = QTUser.tUser;
		return query.from(tuser).list(tuser);
	}
	
}
