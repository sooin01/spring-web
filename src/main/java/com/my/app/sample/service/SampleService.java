package com.my.app.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.sample.dao.SampleDao;
import com.my.app.sample.vo.SampleVo;

@Service
public class SampleService {

	@Autowired
	private SampleDao sampleDao;
	
	public List<SampleVo> list() {
		return sampleDao.list();
	}

	public SampleVo get(String user) {
		return sampleDao.get(user);
	}
	
}
