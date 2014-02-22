package com.zs.light.spider.client.start;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zs.light.spider.client.dao.impl.Mg98Dao;
import com.zs.light.spider.client.model.PicturePageCrawlModel;
import com.zs.light.spider.client.scheduler.impl.EachCenterThreadPolls;
import com.zs.light.spider.core.model.PicturePageUrl;
import com.zs.light.spider.core.model.Url;

public class Start {
	
	/** 总入口， 除quartz启动另行配置，其余启动从这里开始 
	 * @throws Exception **/
	public static void main(String[] args) throws Exception{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
		
		/**
		 * 线程池会阻止jvm退出
		 */
		EachCenterThreadPolls ectp = (EachCenterThreadPolls) ctx.getBean("eachCenterThreadPolls");
		
		Mg98Dao mg98Dao = (Mg98Dao) ctx.getBean("mg98Dao");
		
		List<Url> urls = mg98Dao.findTodoUrl();
		
		for(Url url : urls) {
			
			PicturePageUrl purl = new PicturePageUrl();
			purl.setType(url.getType());
			purl.setFilePath("E:/XMPZR/MG98/");
			purl.setAddress(url.getAddress());
			PicturePageCrawlModel ppcm = new PicturePageCrawlModel(purl, null);
			ppcm.setMg98Dao(mg98Dao);
			ectp.addModel(ppcm);
			
		}

		System.out.println("Done!");
	}
}