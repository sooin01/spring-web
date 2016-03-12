package com.my.app.user.dao;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.my.app.user.domain.TUser;

@Repository
public interface UserDao extends CrudRepository<TUser, String>, QueryDslPredicateExecutor<TUser> {

}
