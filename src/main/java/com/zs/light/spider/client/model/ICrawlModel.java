package com.zs.light.spider.client.model;

/**
 * 相当于一个抓取模型，贯穿整个抓取过程
 * 从构造到抓取，到保存，以及途中的各种信息，
 * 注意： 
 * 1 注意抓取单位的粒度，相关联的可以以一个单位进行，比如相关的ajax请求， 比如一个页面的多个图片。
 * 
 * @author zhangshuo
 *
 */
public interface ICrawlModel extends Runnable{
	
	// 核心方法  后续方法在  此之后 抽象类实现该方法，具体子类调用抽象类方法
	public boolean crawl();
}