package com.my.app.lifecycle.task;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VnfTask extends RecursiveTask<Object> {
	
	private static final long serialVersionUID = -3280595710953364369L;
	
	private static Logger logger = LoggerFactory.getLogger(VnfTask.class);

	@Override
	protected Object compute() {
		logger.info("VNF task start.");
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
		}
		
		logger.info("VNF task end.");
		return null;
	}

}
