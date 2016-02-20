package com.my.app.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.my.app.user.domain.QUser;
import com.my.app.user.domain.User;
import com.mysema.query.jpa.impl.JPAQuery;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<User> getUserList() {
		JPAQuery query = new JPAQuery(entityManager);
		QUser user1 = QUser.user1;
		return query.from(user1).list(user1);
	}
	
}
