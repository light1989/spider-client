package com.zs.light.spider.client.scheduler.impl;

import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zs.light.spider.client.model.ICrawlModel;
import com.zs.light.spider.client.scheduler.AbstractCenterThreadPolls;

public class EachCenterThreadPolls extends AbstractCenterThreadPolls {
	
	private static Logger logger = LoggerFactory.getLogger(EachCenterThreadPolls.class);
	
	/**
	 * 不同的线程池，每个池负责一个类型的url，可以确保线程池被充分利用，并且不会出现网站被封现象。
	 * 执行器需要配置
	 * 不同的类型配置不同的执行器
	 */
	@Resource
	private Map<String, ExecutorService> executorMap;
	
	public void setExecutorMap(Map<String, ExecutorService> executorMap) {
		this.executorMap = executorMap;
	}

	public Map<String, ExecutorService> getExecutorMap() {
		return executorMap;
	}

	public boolean addModel(ICrawlModel model) {
		ExecutorService executor = executorMap.get(model.getType());
		model.setCenterThreadPolls(this);
		executor.execute(model);
		logger.info("new model task added...");
		return true;
	}
}