package com.zs.light.spider.client.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zs.light.spider.client.model.PicturePageCrawlModel;
import com.zs.light.spider.client.scheduler.impl.EachCenterThreadPolls;
import com.zs.light.spider.core.model.PicturePageUrl;

public class Start {
	
	/** 总入口， 除quartz启动另行配置，其余启动从这里开始 **/
	public static void main(String[] args){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
		
		/**
		 * 线程池会阻止jvm退出
		 */
		EachCenterThreadPolls ectp = (EachCenterThreadPolls) ctx.getBean("eachCenterThreadPolls");
		
		PicturePageUrl url = new PicturePageUrl();
		url.setType("MG_PIC_PAGE");
		url.setAddress("http://meigui98.com/thread-49622-1-5.html");
		url.setFilePath("E:/XMPZR/MG98/");
		
		PicturePageCrawlModel ppcm = new PicturePageCrawlModel(url, null);
		
		ectp.addModel(ppcm);

		System.out.println(ectp);
	}
}