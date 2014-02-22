package com.zs.light.spider.client.start;

import java.io.BufferedReader;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zs.light.spider.client.model.MgListPage;
import com.zs.light.spider.client.scheduler.impl.EachCenterThreadPolls;
import com.zs.light.spider.core.model.Url;
import com.zs.light.spider.model.test.HtmlTaskTest;

public class StartGetList {
	
	private static Logger logger = LoggerFactory.getLogger(StartGetList.class);
	
	/** 总入口， 除quartz启动另行配置，其余启动从这里开始 
	 * @throws Exception **/
	public static void main(String[] args) throws Exception{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
		
		/**
		 * 线程池会阻止jvm退出
		 */
		EachCenterThreadPolls ectp = (EachCenterThreadPolls) ctx.getBean("eachCenterThreadPolls");
		
		BufferedReader reader = new BufferedReader(new FileReader("E:/XMPZR/MG98/foot/MG_LIST_PAGE.txt"));
		
		String line = reader.readLine();
		while(line != null){
			if(!line.trim().equals("")) {
				Url url = new Url();
				url.setType("MG_LIST_PAGE");
				url.setAddress(line);
				MgListPage mlp = new MgListPage(url);
				logger.info("get start.." + url.getAddress());
				ectp.addModel(mlp);
			}
			line = reader.readLine();
		}
		System.out.println("Done");
	}
}