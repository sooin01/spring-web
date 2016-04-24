package com.my.app.vnfr.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.app.vnfr.vo.VnfrVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/jdbc-context.xml"})
public class VnfrServiceTest {

	@Autowired
	private VnfrService vnfrService;
	
	@Test
	public void testGetVnfrList() {
		String nsrId = "1c2883ba-07cf-11e6-a42b-7a79193b956c";
		List<VnfrVo> vnfrList = vnfrService.getVnfrList(nsrId);
		
		Map<Integer, List<VnfrVo>> vnfrMap = vnfrList.stream().map(p -> {
			if (p.getSequence() == null) p.setSequence(0);
			return p;
		}).collect(Collectors.groupingBy(VnfrVo::getSequence));
		for (Entry<Integer, List<VnfrVo>> entry : vnfrMap.entrySet()) {
			for (VnfrVo vnfrVo : entry.getValue()) {
				System.out.println(entry.getKey() + " => " + vnfrVo.toString());
			}
		}
		
		System.out.println("================================================");
		
		List<Integer> sequenceList = vnfrMap.entrySet().stream()
				.map(p -> p.getKey()).sorted((e1, e2) -> e2.compareTo(e1))
				.collect(Collectors.toList());
		for (int i = 0; i < sequenceList.size(); i++) {
			Integer sequence = sequenceList.get(i);
			
			for (VnfrVo vnfrVo : vnfrMap.get(sequence)) {
				System.out.println(sequence + " => " + vnfrVo.toString());
			}
			
			if (sequenceList.size() - 1 != i) {
				System.out.println("waiting..");
				try { Thread.sleep(2000); } catch (InterruptedException e) { }
			}
		}
	}
	
}
