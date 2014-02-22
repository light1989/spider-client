package com.zs.light.spider.model.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zs.light.spider.client.model.MgListPage;
import com.zs.light.spider.client.model.PicturePageCrawlModel;
import com.zs.light.spider.core.model.PicturePageUrl;
import com.zs.light.spider.core.model.Url;

public class HtmlTaskTest {
	
	private static Logger logger = LoggerFactory.getLogger(HtmlTaskTest.class);
	
	public static void main(String[] args) {
		
//		PicturePageUrl url = new PicturePageUrl();
//		url.setType("MG98LIST");
		// url.setUrl("http://meigui98.com/forum-37-1.html");
//		url.setAddress("http://meigui98.com/thread-53616-1-3.html");
		
//		HtmlTask ht = new HtmlTask(url);
//		ht.download();
//		PicturePageResult result = new PicturePageResult();
//		result.setFilePath("E:\\XMPZR\\MG98\\1\\");
		
		
		
//		PicturePageCrawlModel ppcm = new PicturePageCrawlModel(url, result);
//		ppcm.crawl();
		
		Url url = new Url();
		url.setType("MG_LIST_PAGE");
		url.setAddress("http://meigui98.com/forum-37-18.html");
		
		MgListPage mlp = new MgListPage(url);
		mlp.crawl();
	}
}