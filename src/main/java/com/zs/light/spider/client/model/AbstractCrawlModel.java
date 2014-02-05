package com.zs.light.spider.client.model;

import com.zs.light.spider.core.model.PicturePageResult;
import com.zs.light.spider.core.model.PicturePageUrl;


public abstract class AbstractCrawlModel implements ICrawlModel{
	
	/**
	 * url
	 */
	protected PicturePageUrl url;
	
	/**
	 * 返回
	 */
	protected PicturePageResult result;
	
	/**
	 * 构造函数
	 */
	public AbstractCrawlModel(PicturePageUrl url, PicturePageResult result){
		this.url = url;
		this.result = result;
	}
	
	/**
	 * 任务模型的类型即为url的类型
	 */
	public String getType(){
		return url.getType();
	}

}