package com.zs.light.spider.client.model;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zs.light.spider.client.dao.impl.Mg98Dao;
import com.zs.light.spider.client.domain.MgPic;
import com.zs.light.spider.client.downloadUtil.PictureTask;
import com.zs.light.spider.core.model.PictureUrl;

public class PictureModel extends AbstractCrawlModel{

	private static Logger logger = LoggerFactory.getLogger(PictureModel.class);
	
	@Resource
	private Mg98Dao mg98Dao;
	
	public void setMg98Dao(Mg98Dao mg98Dao){
		this.mg98Dao = mg98Dao;
	}
	
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
			MgPic mgPic = new MgPic();
			mgPic.setAddress(url.getAddress());
			mgPic.setStatus("DONE");
			mg98Dao.updatePicStatus(mgPic);
			return true;
		}catch(Exception ex){
			logger.error("Download picture" + url + "failed!", ex);
			MgPic mgPic = new MgPic();
			mgPic.setAddress(url.getAddress());
			mgPic.setStatus("FAILED");
			mg98Dao.updatePicStatus(mgPic);
		}
		return false;
	}

	public String getType() {
		return url.getType();
	}
}