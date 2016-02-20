package com.my.app.sample.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableMap;
import com.my.app.sample.vo.SampleVo;

@Repository
public class SampleDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<SampleVo> list() {
		return sqlSession.selectList("SampleDao.get");
	}

	public SampleVo get(String user) {
		return sqlSession.selectOne("SampleDao.get", ImmutableMap.of("user", user));
	}
	
}
