package com.zs.light.spider.client.model;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zs.light.spider.client.dao.impl.Mg98Dao;
import com.zs.light.spider.client.domain.MgPic;
import com.zs.light.spider.client.downloadUtil.HtmlTask;
import com.zs.light.spider.core.model.PicturePageResult;
import com.zs.light.spider.core.model.PicturePageUrl;
import com.zs.light.spider.core.model.PictureUrl;
import com.zs.light.spider.core.model.Url;

public class PicturePageCrawlModel extends AbstractCrawlModel{

	private static Logger logger = LoggerFactory.getLogger(PicturePageCrawlModel.class);
	
	@Resource
	private Mg98Dao mg98Dao;
	
	public void setMg98Dao(Mg98Dao mg98Dao){
		this.mg98Dao = mg98Dao;
	}
	
	private PicturePageUrl url;
	
	private PicturePageResult result;
	/**
	 * 构造函数
	 * @param url
	 */
	public PicturePageCrawlModel(PicturePageUrl url, PicturePageResult result) {
		this.url = url;
		this.result = result;
	}

	public boolean crawl() {
		
		try{
			
			String html = HtmlTask.download(url.getAddress());
			
			Document doc = Jsoup.parse(html);
			
			String folder = "default";
			Elements elsForder = doc.select("title");
			if(elsForder.size() > 0){
				folder = elsForder.get(0).text();
				folder = folder.replaceAll("/", "");
			}
			/**
			 * 解析规则，以后改进
			 */
			Elements els = doc.select("dl.t_attachlist.attachimg img");
			
			for(Element e : els){
				try{
					String src = e.attr("src");
					String name = e.attr("alt");
					
					String mg98 = "http://meigui98.com/";
					
					PictureUrl pu = new PictureUrl();
					pu.setAddress(mg98+src);
					pu.setFilePath(url.getFilePath() + folder + "/");
					pu.setFileName(name);
					pu.setType("MG_PIC");
					
					PictureModel pm = new PictureModel(pu);
					pm.setMg98Dao(mg98Dao);
					/**
					 * 添加进线程池
					 */
					centerThreadPolls.addModel(pm);
					
					MgPic mp = new MgPic();
					mp.setAddress(pu.getAddress());
					mp.setFilename(pu.getFilePath() + pu.getFileName());
					mp.setStatus("TODO");
					mg98Dao.insertPic(mp);
					
					logger.info("src=" + src + " alt=" + name);
					
				}catch(Exception ex){
					logger.error("PicturePageCrawlModel crawl failed.", ex);
				}
			} // for
			
			/** 标记处理完成 **/
			Url rurl = new Url();
			rurl.setAddress(url.getAddress());
			rurl.setStatus("DONE");
			mg98Dao.updateUrlStatus(rurl);
			
			/** 等待10s 进行下一个任务 **/
			Thread.sleep(1000L * 10);
			
			return true;
		}catch(Exception ex){
			logger.error("Download address=" + url.getAddress() +"failed.", ex);
			/** 标记处理完成 **/
			Url rurl = new Url();
			rurl.setAddress(url.getAddress());
			rurl.setStatus("FAILED");
			mg98Dao.updateUrlStatus(rurl);
			return false;
		}
	}

	/**
	 * 返回抓取类型
	 */
	public String getType() {
		return url.getType();
	}
}