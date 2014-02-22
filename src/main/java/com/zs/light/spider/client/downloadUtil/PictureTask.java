package com.zs.light.spider.client.downloadUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;


public class PictureTask {

	
	public static boolean download(String url, String filePath, String fileName) {
		
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);//连接时间
		httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 120000);//数据传输时间
		try{
			
			HttpGet httpget = new HttpGet(url);
			
			//伪装成google的爬虫JAVA问题查询
			httpget.setHeader("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
			// Execute HTTP request
			System.out.println("executing request " + httpget.getURI());
			
			

			File path = new File(filePath);
			if(!path.exists()){
				path.mkdir();
			}
			
			File storeFile = new File(filePath + fileName);
			if(storeFile.exists()){
				return true;
			}
			
			HttpResponse response = httpclient.execute(httpget);
			
			FileOutputStream output = new FileOutputStream(storeFile);

			// 得到网络资源的字节数组,并写入文件
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				try {
					byte b[] = new byte[1024];
					int j = 0;
					while( (j = instream.read(b))!=-1){
						output.write(b,0,j);
					}
					output.flush();
					output.close();
				} catch (IOException ex) {
					// In case of an IOException the connection will be released
					// back to the connection manager automatically
					throw ex;
				} catch (RuntimeException ex) {
					// In case of an unexpected exception you may want to abort
					// the HTTP request in order to shut down the underlying
					// connection immediately.
					httpget.abort();
					throw ex;
				} finally {
					// Closing the input stream will trigger connection release
					try { instream.close(); } 
					catch (Exception ignore) {}
				}
			}
		} catch (Exception e) {
			// logger.error(e.getMessage(), e);
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		
		
		return false;
	}	
}