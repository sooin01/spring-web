package com.my.app.lifecycle.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NsTask {
	
	private static Logger logger = LoggerFactory.getLogger(NsTask.class);
	
	public void instantiate() {
		ForkJoinPool pool = new ForkJoinPool();
		
		List<VnfTask> vnfTaskList = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			VnfTask vnfTask = new VnfTask();
			pool.execute(vnfTask);
			vnfTaskList.add(vnfTask);
		}
		
		boolean isCompleted = false;
		while (true) {
			if (isCompleted) {
				break;
			}
			
			for (VnfTask vnfTask : vnfTaskList) {
				if (vnfTask.isDone()) {
					isCompleted = true;
					break;
				}
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
				logger.info("Ns task polling.");
			} catch (InterruptedException e) {
			}
		}
		
		pool.shutdown();
	}

}
