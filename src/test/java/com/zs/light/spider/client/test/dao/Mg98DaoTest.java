package com.zs.light.spider.client.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.zs.light.spider.client.dao.impl.Mg98Dao;
import com.zs.light.spider.client.domain.MgPic;
import com.zs.light.spider.core.model.Url;

/**
 * 测试类
 * @author zhangshuo
 */
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/applicationContext-dataSource.xml" })
public class Mg98DaoTest extends AbstractJUnit4SpringContextTests {
	
	@Resource
	private Mg98Dao mg98Dao;
	
	@Test
	public void exportOpponentProductListTest(){
		MgPic mgPic = new MgPic();
		mgPic.setAddress("sadf");
		mgPic.setFilename("4567");
		mgPic.setStatus("TODO");
		mg98Dao.insertPic(mgPic);
//		List<Url> urls = mg98Dao.findTodoUrl();
//		Url url = urls.get(0);
//		url.setStatus("DONE");
//		mg98Dao.updateUrlStatus(url);
		
		
//		mg98Dao.updatePicStatus(mgPic);
		
//		System.out.println(mg98Dao.findByaddress("http://meigui98.com/attachments/forumid_37/1303290945f941dde293880738.jpg"));
	}
}
