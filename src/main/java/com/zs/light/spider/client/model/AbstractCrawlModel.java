package com.zs.light.spider.client.model;

import com.zs.light.spider.client.scheduler.ICenterThreadPolls;

public abstract class AbstractCrawlModel implements ICrawlModel{
	
	/**
	 * 线程池对象 由于先线程池用添加子任务
	 */
	protected ICenterThreadPolls centerThreadPolls;
	
	public void run() {
		/**
		 * 可以线程池启动，也可以直接启动，如果需要线程池启动，必须要有TYPE
		 */
		this.crawl();
	}

	public void setCenterThreadPolls(ICenterThreadPolls centerThreadPolls) {
		this.centerThreadPolls = centerThreadPolls;
	}
}