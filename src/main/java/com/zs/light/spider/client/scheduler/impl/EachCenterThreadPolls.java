package com.zs.light.spider.client.scheduler.impl;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

import javax.annotation.Resource;

import com.zs.light.spider.client.downloadUtil.PictureTask;
import com.zs.light.spider.client.scheduler.ACenterThreadPolls;
import com.zs.light.spider.core.model.AbstractUrl;

public class EachCenterThreadPolls extends ACenterThreadPolls {
	
	/**
	 * 不同的线程池，每个池负责一个类型的url，可以确保线程池被充分利用，并且不会出现网站被封现象。
	 * 执行器需要配置
	 */
	@Resource
	private Map<String, ExecutorService> executorMap;
	
	public void setExecutorMap(Map<String, ExecutorService> executorMap) {
		this.executorMap = executorMap;
	}

	public Map<String, ExecutorService> getExecutorMap() {
		return executorMap;
	}

	public boolean addUrl(AbstractUrl url) {
//		ExecutorService executor = executorMap.get(url.getType());
//		PictureTask pictureTask = new PictureTask(url);
//		executor.execute(pictureTask);
		return true;
	}
}