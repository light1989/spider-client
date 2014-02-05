package com.zs.light.spider.client.scheduler;

import com.zs.light.spider.client.model.ICrawlModel;

public interface ICenterThreadPolls {
	/**
	 * 添加一种类型的线程
	 */
	//public boolean addType();
	
	/**
	 * 添加一个任务 可运行的模型
	 */
	public boolean addModel(ICrawlModel model);
}