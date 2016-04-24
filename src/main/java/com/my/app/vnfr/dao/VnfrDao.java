package com.my.app.vnfr.dao;

import java.util.List;

import com.my.app.vnfr.vo.VnfrVo;

public interface VnfrDao {

	public List<VnfrVo> getVnfrList(String nsrId);

}
