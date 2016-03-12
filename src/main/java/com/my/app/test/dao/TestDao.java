package com.my.app.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.my.app.user.domain.TUser;

public interface TestDao extends CrudRepository<TUser, String> {

}
