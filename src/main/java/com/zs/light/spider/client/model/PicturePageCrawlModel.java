package com.zs.light.spider.client.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.zs.light.spider.client.downloadUtil.HtmlTask;
import com.zs.light.spider.client.downloadUtil.PictureTask;
import com.zs.light.spider.core.model.AbstractResult;
import com.zs.light.spider.core.model.AbstractUrl;
import com.zs.light.spider.core.model.PicturePageResult;
import com.zs.light.spider.core.model.PicturePageUrl;

public class PicturePageCrawlModel extends AbstractCrawlModel{

	/**
	 * 构造函数
	 * @param url
	 */
	public PicturePageCrawlModel(PicturePageUrl url, PicturePageResult result) {
		super(url, result);
	}

	public boolean crawl() {
		try{
			
			String html = HtmlTask.download(url.getUrl());
			
			Document doc = Jsoup.parse(html);
			
			Elements els = doc.select("dl.t_attachlist.attachimg img");
			
			for(Element e : els){
				try{
					String src = e.attr("src");
					String name = e.attr("alt");
					
					
					
					String mg98 = "http://meigui98.com/";
					
					PictureTask.download(mg98+src, result.getFilePath() + name);
					
					System.out.println("src=" + src);
					System.out.println("alt=" + name);
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	public void run() {
		// TODO Auto-generated method stub
	}
	
}