package com.zs.light.spider.client.scheduler;

import com.zs.light.spider.core.model.Url;

public interface ICenterThreadPolls {
	/**
	 * 添加一种类型的线程
	 */
	//public boolean addType();
	
	/**
	 * 添加一个URL
	 */
	public boolean addUrl(Url url);
}