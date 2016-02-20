package com.my.app.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.sample.dao.SampleDao;
import com.my.app.sample.vo.UserVo;

@Service
public class SampleService {

	@Autowired
	private SampleDao sampleDao;
	
	public List<UserVo> list() {
		return sampleDao.list();
	}

	public UserVo get(String user) {
		return sampleDao.get(user);
	}
	
}
