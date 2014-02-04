package com.zs.light.spider.client.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zs.light.spider.client.scheduler.impl.EachCenterThreadPolls;
import com.zs.light.spider.core.model.AbstractUrl;
import com.zs.light.spider.core.model.PictureUrl;

public class Start {
	
	/** 总入口， 除quartz启动另行配置，其余启动从这里开始 **/
	public static void main(String[] args){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
		
		EachCenterThreadPolls ectp = (EachCenterThreadPolls) ctx.getBean("eachCenterThreadPolls");
		
		PictureUrl url = new PictureUrl();
		
		url.setType("MG98PIC");
		url.setUrl("http://meigui98.com/attachments/forumid_37/131226174275be27c976a71e0c.jpg.thumb.jpg");
		
		ectp.addUrl(url);
		
		try {
			Thread.sleep(1000 * 60 * 60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ectp);
	}
}