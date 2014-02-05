package com.zs.light.spider.client.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zs.light.spider.client.downloadUtil.PictureTask;
import com.zs.light.spider.core.model.PictureUrl;

public class PictureModel extends AbstractCrawlModel{

	private static Logger logger = LoggerFactory.getLogger(PictureModel.class);
	
	private PictureUrl url;
	/**
	 * 构造函数
	 * @param url
	 */
	public PictureModel(PictureUrl url) {
		this.url = url;
	}

	public boolean crawl() {
		try{
			logger.info("Downloading picture" + url);
			PictureTask.download(url.getAddress(), url.getFilePath(), url.getFileName());
			return true;
		}catch(Exception ex){
			logger.error("Download picture" + url + "failed!", ex);
		}
		return false;
	}

	public String getType() {
		return url.getType();
	}
}