package com.zs.light.spider.client.dao;

import java.util.List;

import com.zs.light.spider.client.domain.MgPic;
import com.zs.light.spider.core.model.Url;

public interface IMg98Dao {
	
	/**
	 * 查看url是否存在
	 * @return
	 */
	public Integer findByaddress(String address);
	
	/**
	 * 插入一条图片信息
	 */
	public void insertPic(MgPic mgPic);
	
	/**
	 * 更新图片状态
	 */
	public void updatePicStatus(MgPic mgPic);
	
	/**
	 * 获取未处理URL
	 */
	public List<Url> findTodoUrl();
	
	/**
	 * 更新任务状态
	 */
	public void updateUrlStatus(Url url);
}