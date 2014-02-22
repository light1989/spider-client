package com.zs.light.spider.client.model;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zs.light.spider.client.downloadUtil.HtmlTask;
import com.zs.light.spider.core.model.Url;

public class MgListPage extends AbstractCrawlModel {

	private static Logger logger = LoggerFactory.getLogger(PicturePageCrawlModel.class);
	
	private Url url;
	
	public MgListPage(Url url){
		this.url = url;
	}
	
	public boolean crawl() {
		try{
			
			String html = HtmlTask.download(url.getAddress());
			
			Document doc = Jsoup.parse(html);
			
			Elements els = doc.select("th.subject.common span a");
			
			String mg98 = "http://meigui98.com/";
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("E:/XMPZR/MG98/foot/MG_PIC_PAGE.txt", true));
			for(Element e : els){
				logger.info(mg98 + e.attr("href"));
				writer.write(mg98 + e.attr("href"));
				writer.newLine();
			}
			writer.close();
			
			return true;
			
		}catch(Exception ex){
			logger.error("MgListPage crawl", ex);
		}
		return false;
	}

	public String getType() {
		return url.getType();
	}
	
}