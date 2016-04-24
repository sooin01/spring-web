package com.my.app.vnfr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.vnfr.dao.VnfrDao;
import com.my.app.vnfr.vo.VnfrVo;

@Service
public class VnfrService {

	@Autowired
	private VnfrDao vnfrDao;
	
	public List<VnfrVo> getVnfrList(String nsrId) {
		return vnfrDao.getVnfrList(nsrId);
	}
	
}
