package com.zs.light.spider.client.downloadUtil;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;


public class HtmlTask{

	public static String download(String url) {
		
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);//连接时间
		httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 60000);//数据传输时间

		try{
			
			HttpGet httpget = new HttpGet(url);
			
			//伪装成google的爬虫JAVA问题查询
			httpget.setHeader("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
			// Execute HTTP request
			System.out.println("executing request " + httpget.getURI());
			
			HttpResponse response = httpclient.execute(httpget);
			

			// 得到网络资源的字节数组,并写入文件
			HttpEntity entity = response.getEntity();

			
			
			if (entity == null)
				return "";

			String a = EntityUtils.toString(entity, "gbk");
			
			/** 这个方法也可以把底层的流给关闭了  **/
			EntityUtils.consume(entity);
			
			return a;
			 
//			Document doc = Jsoup.parse(a);
//			
//			Elements els = doc.select("th.subject.common span");
//			
//			for(Element e : els){
//				System.out.println(e.toString());
//			}
//			
//			System.out.println("test");
			
		} catch (Exception e) {
			// logger.error(e.getMessage(), e);
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		
		return null;
	}
}