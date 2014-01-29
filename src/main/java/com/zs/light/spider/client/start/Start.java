package com.zs.light.spider.client.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zs.light.spider.client.scheduler.impl.EachCenterThreadPolls;

public class Start {
	
	/** 总入口， 除quartz启动另行配置，其余启动从这里开始 **/
	public static void main(String[] args){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
		
		EachCenterThreadPolls ectp = (EachCenterThreadPolls) ctx.getBean("eachCenterThreadPolls");
		
		System.out.println(ectp);
	}
}