package com.my.app.lifecycle.service;

import org.springframework.stereotype.Service;

import com.my.app.lifecycle.task.NsTask;

@Service
public class NsService {

	public void instantiate() {
		NsTask nsTask = new NsTask();
		nsTask.instantiate();
	}
	
}
