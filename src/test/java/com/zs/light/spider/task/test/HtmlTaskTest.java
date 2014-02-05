package com.zs.light.spider.task.test;

import com.zs.light.spider.client.model.PicturePageCrawlModel;
import com.zs.light.spider.core.model.PicturePageResult;
import com.zs.light.spider.core.model.PicturePageUrl;

public class HtmlTaskTest {
	
	public static void main(String[] args) {
		
		PicturePageUrl url = new PicturePageUrl();
//		url.setType("MG98LIST");
		// url.setUrl("http://meigui98.com/forum-37-1.html");
		url.setAddress("http://meigui98.com/thread-53616-1-3.html");
		
//		HtmlTask ht = new HtmlTask(url);
//		ht.download();
		PicturePageResult result = new PicturePageResult();
		result.setFilePath("E:\\XMPZR\\MG98\\1\\");
		
		
		
		PicturePageCrawlModel ppcm = new PicturePageCrawlModel(url, result);
		ppcm.crawl();
	}
}