package com.zs.light.spider.client.scheduler.impl;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.zs.light.spider.client.scheduler.ACenterThreadPolls;
import com.zs.light.spider.core.model.AbstractUrl;

/**
 * 核心线程类
 * @author yfzhangshuo
 *
 */
public class PersistentCenterThreadPolls extends ACenterThreadPolls {
	
	/**
	 *任务队列 因为任务不会创建新的线程，在原来的线程上执行，所以需要这个
	 */
	private Queue<AbstractUrl> taskQueue = new ConcurrentLinkedQueue<AbstractUrl>();
	
	private static final int POLL_SIZE = 10;
	
	public boolean addUrl(AbstractUrl url) {
		return taskQueue.add(url);
	}
	
	
}